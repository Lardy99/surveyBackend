package com.surveyspring.surveyspring.repository;

import com.surveyspring.surveyspring.model.Answer;
import com.surveyspring.surveyspring.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Page<Answer> findAll(Pageable pageable);
}

