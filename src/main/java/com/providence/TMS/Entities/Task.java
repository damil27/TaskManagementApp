package com.providence.TMS.Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Task {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String publicId;

    private String date;
    @NotEmpty
    private String startTime;
    @NotEmpty
    private String stopTime;
    @NotEmpty
    @Column(length = 1000)
    private String description;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public Task(String date, String startTime, String stopTime, String description, User user) {
        this.date = date;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.description = description;
        this.user = user;
    }

    public Task(String publicId) {
        this.publicId = publicId;
    }

    public Task(String date, String startTime, String stopTime, String description) {
        this.date = date;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.description = description;
    }

    public Task() {
    }


    public String getPublicId() {
        return this.publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId= publicId;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStopTime() {
        return this.stopTime;
    }

    public void setStopTime(String stopTime) { this.stopTime = stopTime;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
