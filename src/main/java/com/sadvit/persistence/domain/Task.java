package com.sadvit.persistence.domain;

import com.sadvit.persistence.domain.type.Status;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Task extends AbstractEntity {

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private int planTime;

    @Column
    private double difficulty;

    @Column
    private Date openDate;

    @Column
    private Date acceptDate;

    @Column
    private Date closeDate;

    @Column
    private Status status;

    @ManyToOne
    @JoinColumn(name="requirement_id")
    private Requirement requirement;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    public Task(String name, String description, int planTime, double difficulty, Date openDate, Date acceptDate, Date closeDate, Status status, Requirement requirement, Employee employee) {
        this.name = name;
        this.description = description;
        this.planTime = planTime;
        this.difficulty = difficulty;
        this.openDate = openDate;
        this.acceptDate = acceptDate;
        this.closeDate = closeDate;
        this.status = status;
        this.requirement = requirement;
        this.employee = employee;
    }

    public Task() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPlanTime() {
        return planTime;
    }

    public void setPlanTime(int planTime) {
        this.planTime = planTime;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", planTime=" + planTime +
                ", difficulty=" + difficulty +
                ", openDate=" + openDate +
                ", acceptDate=" + acceptDate +
                ", closeDate=" + closeDate +
                ", status=" + status +
                ", requirement=" + requirement +
                ", employee=" + employee +
                '}';
    }

    @Override
    public void exchange(Object object) {
        // TODO realize
    }
}
