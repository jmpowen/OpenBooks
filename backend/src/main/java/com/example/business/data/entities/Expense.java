package com.example.business.data.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "expense")
public class Expense {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_id")
    private int expense_id;

    @Column(name = "charity_id")
    int charity_id;

    @Column(name = "expense_title")
    String expense_title;

    @Column(name = "expense_description")
    String expense_description;

    @Column(name = "expense_amount")
    double expense_amount;

    @Column(name = "expense_date")
    Date expense_date;

    /* Required by JPA for building properly */
    public Expense() {
        super();
    }
    public Expense(int charity_id, String expense_title, String expense_description, double expense_amount, Date expense_date) {
        this.charity_id = charity_id;
        this.expense_title = expense_title;
        this.expense_description = expense_description;
        this.expense_amount = expense_amount;
        this.expense_date = expense_date;
    }

    public int getExpense_id() {return this.expense_id;}

    public void setExpense_id(int expense_id) {this.expense_id = expense_id;}

    public int getCharity_id() {return this.charity_id;}

    public void setCharity_id(int charity_id) {this.charity_id = charity_id;}

    public String getExpense_title() {return this.expense_title;}

    public void setExpense_title(String expense_title) {this.expense_title = expense_title;}

    public String getExpense_description() {return this.expense_description;}

    public void setExpense_description(String expense_description) {this.expense_description = expense_description;}

    public double getExpense_amount() {return this.expense_amount;}

    public void setExpense_amount(double expense_amount) {this.expense_amount = expense_amount;}

    public Date getExpense_date() {return this.expense_date;}

    public void setExpense_date(Date expense_date) {this.expense_date = expense_date;}


}