package com.surveyspring.surveyspring.repository;

import com.surveyspring.surveyspring.model.Submitted_Answer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubmittedAnswerRepository extends JpaRepository<Submitted_Answer, Long> {
    @Query("select s from Submitted_Answer s where s.id_submitted_survey = ?1")
    List<Submitted_Answer> findById_submitted_survey(long id_submitted_survey);

    Page<Submitted_Answer> findAll(Pageable pageable);
}
