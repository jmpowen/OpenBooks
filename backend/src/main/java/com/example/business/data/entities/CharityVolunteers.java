package com.example.business.data.entities;


import javax.persistence.*;

@Entity
@Table(name = "charity_volunteer")
public class CharityVolunteers {

    @Id
    @Column(name = "volunteer_id")
    int volunteer_id;

    @Column(name = "charity_id")
    private int charity_id;

    @Column(name = "title")
    String title;

    @Column(name = "salary")
    double salary;

    /* Required by JPA for building properly */
    public CharityVolunteers() {
        super();
    }
    public CharityVolunteers(int volunteer_id, int charity_id, String position, double salary) {
        this.volunteer_id = volunteer_id;
        this.charity_id = charity_id;
        this.title = position;
        this.salary = salary;
    }

    public int getVolunteer_id() {return this.volunteer_id;}

    public void setVolunteer_id(int volunteer_id) {this.volunteer_id = volunteer_id;}

    public int getCharity_id() {return this.charity_id;}

    public void setCharity_id(int charity_id) {this.charity_id = charity_id;}

    public String getTitle() {return this.title;}

    public void setTitle(String title) {this.title = title;}

    public double getSalary() {return this.salary;}

    public void setSalary(double salary) {this.salary = salary;}

}
