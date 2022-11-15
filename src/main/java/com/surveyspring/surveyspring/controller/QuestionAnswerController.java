package com.surveyspring.surveyspring.controller;
import com.surveyspring.surveyspring.model.*;
import com.surveyspring.surveyspring.repository.QuestionAnswerRepository;
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

public class QuestionAnswerController {
    @Autowired
    QuestionAnswerRepository repository;

    @GetMapping("/questionanswer")
    public ResponseEntity<List<Question_Answer>> getAllQuestionAnswer() {
        try {
            List<Question_Answer> questionAnswers = new ArrayList<Question_Answer>();

            questionAnswers.addAll(repository.findAll());

            if (questionAnswers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(questionAnswers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(
            value = "/questionanswer",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Question_Answer> createQuestionAnswer(@RequestBody Question_Answer questionAnswer) {
        try {
            Question_Answer newQuestion_Answer=repository.save(new Question_Answer(questionAnswer.getId_question(), questionAnswer.getId_answer()));

            return new ResponseEntity<Question_Answer>(newQuestion_Answer, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
