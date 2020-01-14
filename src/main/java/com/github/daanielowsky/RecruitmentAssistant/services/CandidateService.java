package com.github.daanielowsky.RecruitmentAssistant.services;

import com.github.daanielowsky.RecruitmentAssistant.dto.CandidateDTO;
import com.github.daanielowsky.RecruitmentAssistant.entity.Candidate;
import com.github.daanielowsky.RecruitmentAssistant.repositories.CandidateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public CandidateService(CandidateRepository candidateRepository, MailSender mailSender, UserService userService) {
        this.candidateRepository = candidateRepository;
        this.mailSender = mailSender;
        this.userService = userService;
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

    public void rejectingCandidateApplicationForAJob(Long userID){

        Candidate candidate = candidateRepository.getFirstById(userID);
        String email = candidate.getEmail();
        String position = candidate.getPosition();
        String fullname = userService.getLoggedUser().getFullname();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(email);
        simpleMailMessage.setFrom("CompanyName");
        simpleMailMessage.setSubject("Company Name - " + position + " - rejection");
        simpleMailMessage.setText("Dear " + candidate.getFirstname() + "," +
                "\n unfortunately yours application did not match with our requirements. Please stand by for a another job position open in the future." +
                "\n \n Best Regards" +
                "\n HR Team" +
                "\n" + fullname);

        mailSender.send(simpleMailMessage);

        candidateRepository.delete(candidate);
    }

    public void rejectingCandidateApplicationWithOwnMessage(Long userID, String message) {

        Candidate candidate = candidateRepository.getFirstById(userID);
        String email = candidate.getEmail();
        String position = candidate.getPosition();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(email);
        simpleMailMessage.setFrom("CompanyName");
        simpleMailMessage.setSubject("Company Name - " + position + " - rejection");
        simpleMailMessage.setText(message);

        mailSender.send(simpleMailMessage);

        candidateRepository.delete(candidate);

    }
}
