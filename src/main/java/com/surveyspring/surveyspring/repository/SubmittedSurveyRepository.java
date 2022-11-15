package com.surveyspring.surveyspring.repository;

import com.surveyspring.surveyspring.model.Submitted_Survey;
import com.surveyspring.surveyspring.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubmittedSurveyRepository extends JpaRepository<Submitted_Survey, Long> {
        Optional<Submitted_Survey> findById( long Id);
        Page<Submitted_Survey> findAll(Pageable pageable);
}
