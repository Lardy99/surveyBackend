package com.surveyspring.surveyspring.repository;

import com.surveyspring.surveyspring.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
