package com.surveyspring.surveyspring.model;
import javax.persistence.*;
import java.io.Serializable;

@IdClass(SurveyCompositionPK.class)
@Entity
@Table(name = "survey_composition")
public class Survey_Composition {
    @Id
    @Column(name="id_survey")
    private Long id_survey;

    @Id
    @Column(name="id_question_answer")
    private Long id_question_answer;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_question_answer", nullable = false, insertable = false, updatable = false)
    private Question_Answer question_answer;



    public Survey_Composition() {
    }

    public Survey_Composition(Long id_survey, Long id_question_answer) {
        this.id_survey = id_survey;
        this.id_question_answer = id_question_answer;
    }

    public Long getId_survey() {
        return id_survey;
    }

    public void setId_survey(Long id_survey) {
        this.id_survey = id_survey;
    }

    public Long getId_question_answer() {
        return id_question_answer;
    }

    public void setId_question_answer(Long id_question_answer) {
        this.id_question_answer = id_question_answer;
    }

    public Question_Answer getQuestion_answer() {
        return question_answer;
    }

    public void setQuestion_answer(Question_Answer question_answer) {
        this.question_answer = question_answer;
    }
}

class SurveyCompositionPK implements Serializable{
    private Long id_survey;
    private Long id_question_answer;

    public SurveyCompositionPK() {
    }

    public SurveyCompositionPK(Long id_survey, Long id_question_answer) {
        this.id_survey = id_survey;
        this.id_question_answer = id_question_answer;
    }

}