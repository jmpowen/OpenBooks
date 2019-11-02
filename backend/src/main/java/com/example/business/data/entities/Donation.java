package com.example.business.data.entities;


import javax.persistence.*;

@Entity
@Table(name = "donation")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="donation_id")
    private int donation_id;

    @Column(name = "donation_amount")
    double donation_amount;

    @Column(name = "donation_comment")
    String donation_comment;

    @Column(name = "charity_id")
    int charity_id;

    @Column(name = "donor_id")
    int donor_id;


    /* Required by JPA for building properly */
    public Donation() {
        super();
    }
    public Donation(double donation_amount, String donation_comment, int charity_id, int donor_id) {
        this.donation_amount = donation_amount;
        this.donation_comment = donation_comment;
        this.charity_id = charity_id;
        this.donor_id = donor_id;
    }

    public int getDonation_id() {return this.donation_id;}

    public void setDonation_id(int donation_id) {this.donation_id = donation_id;}

    public double getDonation_amount() {return this.donation_amount;}

    public void setDonation_amount(double donation_amount) {this.donation_amount = donation_amount;}

    public String getDonation_comment() {return this.donation_comment;}

    public void setDonation_comment(String donation_comment) {this.donation_comment = donation_comment;}

    public int getCharity_id() {return this.charity_id;}

    public void setCharity_id(int charity_id) {this.charity_id = charity_id;}

    public int getDonor_id() {return this.donor_id;}

    public void setDonor_id(int donor_id) {
        this.donor_id = donor_id;
    }
}
