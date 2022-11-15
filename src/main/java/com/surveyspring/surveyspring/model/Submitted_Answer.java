package com.surveyspring.surveyspring.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@IdClass(UserPK.class)
@Entity
@Table(name = "submitted_answer")

public class Submitted_Answer{

    @Id
    @Column(name="id_submitted_survey")
    private long id_submitted_survey;

    @Id
    @Column(name="id_question_answer")
    private long id_question_answer;

    public Submitted_Answer(){}

    public Submitted_Answer(long id_submitted_survey, long id_question_answer) {
        this.id_submitted_survey = id_submitted_survey;
        this.id_question_answer = id_question_answer;
    }

    public long getId_submitted_survey() {
        return id_submitted_survey;
    }

    public void setId_submitted_survey(long id_submitted_survey) {
        this.id_submitted_survey = id_submitted_survey;
    }

    public long getId_question_answer() {
        return id_question_answer;
    }

    public void setId_question_answer(long id_question_answer) {
        this.id_question_answer = id_question_answer;
    }
}

class UserPK implements Serializable {
    private long id_submitted_survey;
    private long id_question_answer;

    public UserPK() {
    }

    public UserPK(long id_submitted_survey, long id_question_answer) {
        this.id_submitted_survey = id_submitted_survey;
        this.id_question_answer = id_question_answer;
    }

}
