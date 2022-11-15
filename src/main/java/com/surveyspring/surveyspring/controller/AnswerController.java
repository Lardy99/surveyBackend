package com.surveyspring.surveyspring.controller;

import com.google.gson.Gson;
import com.surveyspring.surveyspring.model.Answer;
import com.surveyspring.surveyspring.model.User;
import com.surveyspring.surveyspring.repository.AnswerRepository;
import com.surveyspring.surveyspring.tool.sortingTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("surveyspring.surveyspring/api")

public class AnswerController {

    @Autowired
    AnswerRepository repository;

    @GetMapping("/answer")
    public ResponseEntity<List<Answer>> getAllAnswers(
            @RequestParam(defaultValue = "0")  int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestBody Optional<String> sort
    ) {
        try {
            List<Sort.Order> orders = new ArrayList<>();

            if (sort.isPresent()) {
                String sorts = sort.get();
                Gson gson = new Gson();
                sortingTool[] criteria = gson.fromJson(sorts, sortingTool[].class);
                for(sortingTool criterio : criteria) {
                    orders.add(new Sort.Order(criterio.getSortDirection(), criterio.getField()));
                }
            }
            else {
                orders.add(new Sort.Order(Sort.Direction.ASC, "answer"));
            }

            Pageable pageCurrent   = PageRequest.of(page, size, Sort.by(orders));
            Page<Answer> pageRecords = repository.findAll(pageCurrent);

            List<Answer> answers = pageRecords.getContent();

            return new ResponseEntity<>(answers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(
            value = "/answer",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Answer> createAnswer(@RequestBody Answer answer) {
        try {
            Answer newAnswer = repository.save(new Answer(answer.getAnswer()));
            return new ResponseEntity<>(newAnswer, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

