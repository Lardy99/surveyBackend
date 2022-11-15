package com.surveyspring.surveyspring.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "submitted_survey")
public class Submitted_Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "id_survey")
    private long id_survey;

    @Column (name = "id_mail")
    private String id_mail;

    public Submitted_Survey(){}

    public Submitted_Survey(long id_survey, String id_mail) {
        this.id_survey = id_survey;
        this.id_mail = id_mail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_survey() {
        return id_survey;
    }

    public void setId_survey(long id_survey) {
        this.id_survey = id_survey;
    }

    public String getId_mail() {
        return id_mail;
    }

    public void setId_mail(String id_mail) {
        this.id_mail = id_mail;
    }
}
