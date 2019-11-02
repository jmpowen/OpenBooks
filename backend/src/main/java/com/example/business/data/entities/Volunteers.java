package com.example.business.data.entities;


import javax.persistence.*;

@Entity
@Table(name = "volunteers")
public class Volunteers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "charity_id")
    private int charity_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "volunteer_id")
    int volunteer_id;

    @Column(name = "position")
    String position;

    @Column(name = "salary")
    double salary;

    /* Required by JPA for building properly */
    public Volunteers() {
        super();
    }
    public Volunteers(int charity_id, int volunteer_id, String position, double salary) {
        this.charity_id = charity_id;
        this.volunteer_id = volunteer_id;
        this.position = position;
        this.salary = salary;
    }

    public int getCharity_id() {return this.charity_id;}

    public void setCharity_id(int charity_id) {this.charity_id = charity_id;}

    public int getVolunteer_id() {return this.volunteer_id;}

    public void setVolunteer_id(int volunteer_id) {this.volunteer_id = volunteer_id;}

    public String getPosition() {return this.position;}

    public void setPosition(String position) {this.position = position;}

    public double getSalary() {return this.salary;}

    public void setSalary(double salary) {this.salary = salary;}

}
