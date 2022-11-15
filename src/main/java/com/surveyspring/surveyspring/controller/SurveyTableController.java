package com.surveyspring.surveyspring.controller;

import com.surveyspring.surveyspring.model.Category;
import com.surveyspring.surveyspring.model.Survey_Table;
import com.surveyspring.surveyspring.model.User;
import com.surveyspring.surveyspring.repository.SurveyTableRepository;
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


public class SurveyTableController {
    @Autowired
    SurveyTableRepository repository;

    @GetMapping("/surveys")
    public ResponseEntity<List<Survey_Table>> getAllSurveys() {
        try {
            List<Survey_Table> surveys = new ArrayList<Survey_Table>();
            surveys.addAll(repository.findAll());
            if (surveys.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(surveys, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*@GetMapping("/surveys/{id}")
    public ResponseEntity<Survey_Table> getSurveyTableById(@PathVariable("id") long id) {
        Optional<Survey_Table> data = repository.findById(String.valueOf(id));

        if (data.isPresent()) {
            return new ResponseEntity<>(data.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

    @PostMapping(
            value = "/survey",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Survey_Table> createSubmitted_survey(@RequestBody Survey_Table survey) {
        try {
            Survey_Table newSurvey = repository.save(new Survey_Table(survey.getId(),survey.getId_mail(), survey.getId_category(), survey.getName(), survey.getDescription(), survey.getPublish_date(), survey.getEnding_date()));
            return new ResponseEntity<>(newSurvey, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

