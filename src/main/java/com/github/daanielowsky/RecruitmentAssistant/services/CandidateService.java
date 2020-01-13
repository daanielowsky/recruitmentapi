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

    public CandidateService(CandidateRepository candidateRepository, MailSender mailSender) {
        this.candidateRepository = candidateRepository;
        this.mailSender = mailSender;
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

    public void rejectingCandidateApplicationForAJob(String userID){

        Candidate candidate = candidateRepository.getFirstById(userID);
        String email = candidate.getEmail();
        String position = candidate.getPosition();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(email);
        simpleMailMessage.setFrom("Company Name");
        simpleMailMessage.setSubject("Company Name - " + position + " - rejection");
        simpleMailMessage.setText("Dear " + candidate.getFirstname() + "" +
                "\n Unfortunately yours application did not match with our requirements. Please stand by for a another job position open in the future." +
                "\n Best Regards" +
                "\n HR Team" +
                "\n Lorem Ipsum");

        mailSender.send(simpleMailMessage);

        candidateRepository.delete(candidate);
    }
}
