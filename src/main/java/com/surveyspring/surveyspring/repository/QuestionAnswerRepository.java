package com.surveyspring.surveyspring.repository;

import com.surveyspring.surveyspring.model.Question_Answer;
import com.surveyspring.surveyspring.model.Submitted_Survey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionAnswerRepository extends JpaRepository<Question_Answer, Long> {
    Page<Question_Answer> findAll(Pageable pageable);
}
