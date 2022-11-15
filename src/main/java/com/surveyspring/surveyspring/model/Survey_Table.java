package com.surveyspring.surveyspring.model;

import javax.persistence.*;

@Entity
@Table(name = "survey_table")
public class Survey_Table {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "id_mail")
    private String id_mail;

    @Column(name = "id_category")
    private long id_category;


    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "publish_date")
    private String publish_date;

    @Column(name = "ending_date")
    private String ending_date;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_category", nullable = false, insertable = false, updatable = false)
    private Category category;

    /*@OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_mail", nullable = false, insertable = false, updatable = false)
    private User user;*/

    public Survey_Table() {}

    //public Survey_Table (String id_mail, long id_category, String name, String description, String publish_date, String ending_date) { }

    public Survey_Table(long id, String id_mail, long id_category, String name, String description, String publish_date, String ending_date) {
        this.id = id;
        this.id_mail = id_mail;
        this.id_category = id_category;
        this.name = name;
        this.description = description;
        this.publish_date = publish_date;
        this.ending_date = ending_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getId_mail () { return this.id_mail; }
    public void setId_mail (String id_mail) { this.id_mail = id_mail; }
    public long getId_category () { return this.id_category; }
    public void setId_category (long id_category) { this.id_category = id_category; }
    public String getName () { return this.name; }
    public void setName (String name) { this.name = name; }
    public String getDescription () { return this.description; }
    public void setDescription (String description) { this.description = description; }
    public String getPublish_date () { return this.publish_date; }
    public void setPublish_date (String publish_date) { this.publish_date = publish_date; }
    public String getEnding_date () { return this.ending_date; }
    public void setEnding_date (String ending_date) { this.ending_date = ending_date; }
    public Category getCategory() {return category;}
    public void setCategory(Category category) {this.category = category;}
    /*public User getUser() {return this.user;}
    public void setUser(User user) {this.user = user;}*/
}


