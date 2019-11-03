package com.example.business.data.entities;


import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "donation")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="donation_id")
    private int donation_id;

    @Column(name = "donation_amount")
    BigDecimal donation_amount;

    @Column(name = "donation_amount_unused")
    BigDecimal donation_amount_unused;

    @Column(name = "donation_comment")
    String donation_comment;

    @Column(name = "donation_date")
    Timestamp donation_date;

    @Column(name = "charity_id")
    int charity_id;

    @Column(name = "donor_id")
    String donor_id;


    /* Required by JPA for building properly */
    public Donation() {
        super();
    }
    public Donation(BigDecimal donation_amount, BigDecimal donation_amount_unused, String donation_comment, Timestamp donation_date, int charity_id, String donor_id) {
        this.donation_amount = donation_amount;
        this.donation_amount_unused = donation_amount_unused;
        this.donation_comment = donation_comment;
        this.donation_date = donation_date;
        this.charity_id = charity_id;
        this.donor_id = donor_id;
    }

    public int getDonation_id() {return this.donation_id;}

    public void setDonation_id(int donation_id) {this.donation_id = donation_id;}

    public BigDecimal getDonation_amount() {return this.donation_amount;}

    public void setDonation_amount(BigDecimal donation_amount) {this.donation_amount = donation_amount;}

    public BigDecimal getDonation_amount_unused() {return this.donation_amount_unused;}

    public void setDonation_amount_unused(BigDecimal donation_amount_unused) {this.donation_amount_unused = donation_amount_unused;}

    public String getDonation_comment() {return this.donation_comment;}

    public void setDonation_comment(String donation_comment) {this.donation_comment = donation_comment;}

    public Timestamp getDonation_date(){return this.donation_date;}

    public void setDonation_date(Timestamp donation_date){ this.donation_date = donation_date;}

    public int getCharity_id() {return this.charity_id;}

    public void setCharity_id(int charity_id) {this.charity_id = charity_id;}

    public String getDonor_id() {return this.donor_id;}

    public void setDonor_id(String donor_id) {
        this.donor_id = donor_id;
    }
}
