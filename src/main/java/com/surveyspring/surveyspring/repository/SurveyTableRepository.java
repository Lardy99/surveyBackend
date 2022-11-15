package com.surveyspring.surveyspring.repository;
import com.surveyspring.surveyspring.model.Category;
import com.surveyspring.surveyspring.model.Survey_Table;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface SurveyTableRepository extends JpaRepository <Survey_Table, Long> {
    //Optional<Survey_Table> findById(long id_survey);
    //Page<Survey_Table> findAll(Pageable pageable);
}
