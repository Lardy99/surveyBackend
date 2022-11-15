package com.surveyspring.surveyspring.controller;
import com.surveyspring.surveyspring.model.Question_Answer;
import com.surveyspring.surveyspring.model.Submitted_Answer;
import com.surveyspring.surveyspring.model.Survey_Composition;
import com.surveyspring.surveyspring.repository.SubmittedAnswerRepository;
import com.surveyspring.surveyspring.repository.SurveyCompositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

public class SurveyCompositionController {

    @Autowired
    SurveyCompositionRepository repository;

    @GetMapping("/survey-composition")
    public ResponseEntity<List<Survey_Composition>> getSurveyComposition() {
        try {
            List<Survey_Composition> survey_compositions = new ArrayList<Survey_Composition>();

            survey_compositions.addAll(repository.findAll());

            if (survey_compositions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(survey_compositions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/survey-composition/{id}")
    public ResponseEntity<List<Survey_Composition>> getSurveyCompositionById(@PathVariable("id_survey") Long id_survey) {
        try {
            List<Survey_Composition> survey_compositionid = new ArrayList<Survey_Composition>();
            survey_compositionid.addAll(repository.findById_survey(id_survey));

            if (survey_compositionid.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(survey_compositionid, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(
            value = "/survey-composition",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Survey_Composition> addSurveyComposition(@RequestBody Survey_Composition surveyComposition) {
        try {
            Survey_Composition newSurvey_Composition=repository.save(new Survey_Composition(surveyComposition.getId_survey(), surveyComposition.getId_question_answer()));

            return new ResponseEntity<Survey_Composition>(newSurvey_Composition, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
