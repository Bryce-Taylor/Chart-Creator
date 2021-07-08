package com.example.Chart.Creator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.Optional;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, length = 255)
    private String title;

    @Column(nullable = true, length = 255)
    private String body;

    private String columnTitle1;
    private String columnTitle2;
    private String columnTitle3;
    private String columnTitle4;
    private String columnTitle5;
    private String columnTitle6;
    private String columnTitle7;
    private String columnTitle8;
    private String columnTitle9;
    private String columnTitle10;



    @ManyToOne(targetEntity = User.class)
    private User creator;


    public Post() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getColumnTitle1() {
        return columnTitle1;
    }

    public void setColumnTitle1(String columnTitle1) {
        this.columnTitle1 = columnTitle1;
    }

    public String getColumnTitle2() {
        return columnTitle2;
    }

    public void setColumnTitle2(String columnTitle2) {
        this.columnTitle2 = columnTitle2;
    }

    public String getColumnTitle3() {
        return columnTitle3;
    }

    public void setColumnTitle3(String columnTitle3) {
        this.columnTitle3 = columnTitle3;
    }

    public String getColumnTitle4() {
        return columnTitle4;
    }

    public void setColumnTitle4(String columnTitle4) {
        this.columnTitle4 = columnTitle4;
    }

    public String getColumnTitle5() {
        return columnTitle5;
    }

    public void setColumnTitle5(String columnTitle5) {
        this.columnTitle5 = columnTitle5;
    }

    public String getColumnTitle6() {
        return columnTitle6;
    }

    public void setColumnTitle6(String columnTitle6) {
        this.columnTitle6 = columnTitle6;
    }

    public String getColumnTitle7() {
        return columnTitle7;
    }

    public void setColumnTitle7(String columnTitle7) {
        this.columnTitle7 = columnTitle7;
    }

    public String getColumnTitle8() {
        return columnTitle8;
    }

    public void setColumnTitle8(String columnTitle8) {
        this.columnTitle8 = columnTitle8;
    }

    public String getColumnTitle9() {
        return columnTitle9;
    }

    public void setColumnTitle9(String columnTitle9) {
        this.columnTitle9 = columnTitle9;
    }

    public String getColumnTitle10() {
        return columnTitle10;
    }

    public void setColumnTitle10(String columnTitle10) {
        this.columnTitle10 = columnTitle10;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }




//    public Date getDateCreated() {
//        return dateCreated;
//    }
//
//    public void setDateCreated(Date dateCreated) {
//        this.dateCreated = dateCreated;
//    }
}
