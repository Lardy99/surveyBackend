package com.surveyspring.surveyspring.controller;

import com.surveyspring.surveyspring.model.Submitted_Answer;
import com.surveyspring.surveyspring.model.Survey_Composition;
import com.surveyspring.surveyspring.repository.SubmittedAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import com.surveyspring.surveyspring.model.*;
import com.surveyspring.surveyspring.repository.SubmittedAnswerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.google.gson.Gson;
import com.surveyspring.surveyspring.model.User;
import com.surveyspring.surveyspring.repository.UserRepository;
import com.surveyspring.surveyspring.tool.sortingTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("surveyspring/api")

public class SubmittedAnswerController {

    @Autowired
    SubmittedAnswerRepository repository;

    @GetMapping("/submitted-answer")
    public ResponseEntity<List<Submitted_Answer>> getSubmittedAnswer() {
        try {
            List<Submitted_Answer> submitted_answer = new ArrayList<Submitted_Answer>();

            submitted_answer.addAll(repository.findAll());

            if (submitted_answer.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(submitted_answer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/submitted-answer/{id_submitted_survey}")
    public ResponseEntity<List<Submitted_Answer>> getSurveyById_submitted_survey(@PathVariable("id_submitted_survey") Long id_submitted_survey) {
        try {
            List<Submitted_Answer> submitted_answers = new ArrayList<>();

            repository.findById_submitted_survey(id_submitted_survey).forEach(submitted_answers::add);

            if (submitted_answers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(submitted_answers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(
            value = "/submitted-answer",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Submitted_Answer> createSubAnswer(@RequestBody Submitted_Answer submittedAnswer) {
        try {
            Submitted_Answer newSubmitted_Answer=repository.save(new Submitted_Answer(submittedAnswer.getId_submitted_survey(), submittedAnswer.getId_question_answer()));

            return new ResponseEntity<Submitted_Answer>(newSubmitted_Answer, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
