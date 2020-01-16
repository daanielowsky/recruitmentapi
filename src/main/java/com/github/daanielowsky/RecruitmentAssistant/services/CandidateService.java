package com.github.daanielowsky.RecruitmentAssistant.services;

import com.github.daanielowsky.RecruitmentAssistant.dto.CandidateDTO;
import com.github.daanielowsky.RecruitmentAssistant.dto.ResourceDTO;
import com.github.daanielowsky.RecruitmentAssistant.entity.Candidate;
import com.github.daanielowsky.RecruitmentAssistant.entity.QualifiedCandidates;
import com.github.daanielowsky.RecruitmentAssistant.repositories.CandidateRepository;
import com.github.daanielowsky.RecruitmentAssistant.repositories.QualifiedCandidatesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.daanielowsky.RecruitmentAssistant.services.Converter.*;

@Service
public class CandidateService {

    private static final Logger logger = LoggerFactory.getLogger(CandidateService.class);

    private CandidateRepository candidateRepository;
    private MailSender mailSender;
    private UserService userService;
    private QualifiedCandidatesRepository qualifiedCandidatesRepository;

    public CandidateService(CandidateRepository candidateRepository, MailSender mailSender, UserService userService, QualifiedCandidatesRepository qualifiedCandidatesRepository) {
        this.candidateRepository = candidateRepository;
        this.mailSender = mailSender;
        this.userService = userService;
        this.qualifiedCandidatesRepository = qualifiedCandidatesRepository;
    }

    public void creatingNewCandidate(CandidateDTO candidateDTO){
        logger.info(candidateDTO.toString());
        Candidate candidate = convertingFromCandidateDtoToCandidateEntity(candidateDTO);
        candidateRepository.save(candidate);
    }

    public List<Candidate> getListOfAllCandidates(){
        List<Candidate> allCandidates = candidateRepository.getAllBy();
        return allCandidates;
    }

    public ResourceDTO getCvOfTheCandidate(Long id) {
        ResourceDTO resourceDTO = new ResourceDTO();
        Candidate candidate = candidateRepository.getFirstById(id);
        if (candidate.getFileType() != null) {
            ByteArrayResource resource = new ByteArrayResource(candidate.getFile());
            resourceDTO.setResource(resource);
            resourceDTO.setContentType(candidate.getFileType());
        }
        return resourceDTO;
    }

    public void acceptingCandidateApplication(Long id) {

        Candidate candidate = candidateRepository.getFirstById(id);
        QualifiedCandidates qualifiedCandidates = convertingFromCandidateToQualifiedCandidate(candidate);
        sendingMailToCandidateThatQualified(candidate);
        qualifiedCandidatesRepository.save(qualifiedCandidates);
        candidateRepository.delete(candidate);
    }

    public List<QualifiedCandidates> gettingListOfAllQualifiedCandidates(){
        List<QualifiedCandidates> allBy = qualifiedCandidatesRepository.getAllBy();
        return allBy;
    }

    //Mailing system

    public void sendingMailToCandidateThatQualified(Candidate candidate){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(candidate.getEmail());
        simpleMailMessage.setFrom("LoremIpsum");
        simpleMailMessage.setSubject(candidate.getPosition() + " - Lorem Ipsum - Congratulations!");
        simpleMailMessage.setText("Dear " + candidate.getFirstname() + ", " +
                "\n You have qualified for the next step of recruitment process. In next 48 hours we will send you a technical skills test that will be" +
                " available for another 24 hours. You will have 1 hour to complete that test. Stay tuned" +
                "\n Good Luck" +
                "\n Lorem Ipsum");

        mailSender.send(simpleMailMessage);
    }

    public void confirmationOfJobApply(CandidateDTO candidateDTO){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("LoremIpsum");
        simpleMailMessage.setTo(candidateDTO.getEmail());
        simpleMailMessage.setSubject("Confirmation of yours application");
        simpleMailMessage.setText("Dear " + candidateDTO.getFirstName() +
                "\n Thank you for your intrest in our job offer. " +
                "\n Best regards" +
                "\n Lorem Ipsum");

        mailSender.send(simpleMailMessage);
    }

    public void rejectingCandidateApplicationWithOwnMessage(Long userID, String message) {

        Candidate candidate = candidateRepository.getFirstById(userID);
        String email = candidate.getEmail();
        String position = candidate.getPosition();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(email);
        simpleMailMessage.setFrom("LoremIpsum");
        simpleMailMessage.setSubject("Lorem Ipsum - " + position + " - rejection");
        simpleMailMessage.setText(message);

        mailSender.send(simpleMailMessage);

        candidateRepository.delete(candidate);

    }

    public void rejectingCandidateApplicationForAJob(Long userID){

        Candidate candidate = candidateRepository.getFirstById(userID);
        String email = candidate.getEmail();
        String position = candidate.getPosition();
        String fullname = userService.getLoggedUser().getFullname();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(email);
        simpleMailMessage.setFrom("LoremIpsum");
        simpleMailMessage.setSubject("Lorem Ipsum - " + position + " - rejection");
        simpleMailMessage.setText("Dear " + candidate.getFirstname() + "," +
                "\n unfortunately yours application did not match with our requirements. Please stand by for a another job position open in the future." +
                "\n \n Best Regards" +
                "\n HR Team of Lorem Ipsum" +
                "\n" + fullname);

        mailSender.send(simpleMailMessage);

        candidateRepository.delete(candidate);
    }
}
