package com.surveyspring.surveyspring.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "question_answer")

public class Question_Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="id_question")
    private long id_question;

    @Column(name="id_answer")
    private long id_answer;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_question", nullable = false, insertable = false, updatable = false)
    private Question question;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_answer", nullable = false, insertable = false, updatable = false)
    private Answer answer;



    public Question_Answer() {}

    public Question_Answer(long id_question, long id_answer) {
        this.id_question = id_question;
        this.id_answer = id_answer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public long getId_question() {
        return id_question;
    }

    public void setId_question(long id_question) {
        this.id_question = id_question;
    }

    public long getId_answer() {
        return id_answer;
    }

    public void setId_answer(long id_answer) {
        this.id_answer = id_answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
