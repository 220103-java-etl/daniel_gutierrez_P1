package com.revature.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.time.LocalDate;

public class AbstractRequests {

    //instance fields

    private Selection selection; //select course
    private BigDecimal amount;
    private String grades;
    private Date localDate; //import localtime&date as placeholder?  System.out.println("Today date: "+date);
    private User u;
    private int rId;
    private String location;
    private Date certDate; //can put this in with local date for urgent request enum.
    private Status status;
    private Deadline deadline;

    public AbstractRequests() {
        super();
    }
    //constructors


    public AbstractRequests(Selection selection, BigDecimal amount, String grades, Date localDate, User u, int rId, String location, Date certDate, Status status, Deadline deadline) {
        this.selection = selection;
        this.amount = amount;
        this.grades = grades;
        this.localDate = localDate;
        this.u = u;
        this.rId = rId;
        this.location = location;
        this.certDate = certDate;
        this.status = status;
        this.deadline = deadline;
    }


    //getters and setters for requests class go here

    public Selection getSelection() {
        return selection;
    }

    public void setSelection(Selection selection) {
        this.selection = selection;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

    public Date getLocalDate() {
        return localDate;
    }

    public void setLocalDate(Date localDate) {
        this.localDate = localDate;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCertDate() {
        return certDate;
    }

    public void setCertDate(Date certDate) {
        this.certDate = certDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Deadline getDeadline() {
        return deadline;
    }

    public void setDeadline(Deadline deadline) {
        this.deadline = deadline;
    }

    //override function for toString goes here daniel.


    @Override
    public String toString() {
        return "AbstractRequests{" +
                "selection=" + selection +
                ", amount=" + amount +
                ", grades='" + grades + '\'' +
                ", localDate=" + localDate +
                ", u=" + u +
                ", rId=" + rId +
                ", location='" + location + '\'' +
                ", certDate=" + certDate +
                ", status=" + status +
                ", deadline=" + deadline +
                '}';
    }
}
