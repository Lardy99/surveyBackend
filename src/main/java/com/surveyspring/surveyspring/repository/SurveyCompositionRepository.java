package com.surveyspring.surveyspring.repository;

import com.surveyspring.surveyspring.model.Submitted_Answer;
import com.surveyspring.surveyspring.model.Submitted_Survey;
import com.surveyspring.surveyspring.model.Survey_Composition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SurveyCompositionRepository extends JpaRepository<Survey_Composition,Long> {
    //Page<Survey_Composition> findAll(Pageable pageable);

    @Query("select s from Survey_Composition s where s.id_survey = ?1")
    List<Survey_Composition> findById_survey(Long id_survey);

}
