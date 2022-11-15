package com.surveyspring.surveyspring.controller;

import com.surveyspring.surveyspring.model.Category;
import com.surveyspring.surveyspring.model.Submitted_Survey;
import com.surveyspring.surveyspring.model.User;
import com.surveyspring.surveyspring.repository.SubmittedSurveyRepository;
import com.surveyspring.surveyspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("surveyspring/api")


public class SubmittedSurveyController {
    @Autowired
    SubmittedSurveyRepository repository;

    @GetMapping("/submit_survey")
    public ResponseEntity<List<Submitted_Survey>> getAllSumSurveys() {
        try {
            List<Submitted_Survey> surveys = new ArrayList<>();

            surveys.addAll(repository.findAll());

            if (surveys.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(surveys, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(
            value = "/submit_survey",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Submitted_Survey> createSubSurvey(@RequestBody Submitted_Survey survey) {
        try {
            /*Optional<Submitted_Survey> _survey = repository.findById(survey.getId());

            if (_survey.isPresent()) {
                return new ResponseEntity<>(null, HttpStatus.CONFLICT);
            }*/

            Submitted_Survey newSubmittedSurvey = repository.save(new Submitted_Survey(survey.getId_survey(),survey.getId_mail()));
            return new ResponseEntity<>(newSubmittedSurvey, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
