package com.kakuritsu.demo.cruddemo.entities;

import jakarta.persistence.*;

@Entity
@Table(name="review")
public class Review {

    public Review(){}

    public Review(String comment) {
        this.comment = comment;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name="comment")
    String comment;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReview() {
        return comment;
    }

    public void setReview(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", review='" + comment + '\'' +
                '}';
    }
}
