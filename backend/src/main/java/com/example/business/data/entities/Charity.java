package com.example.business.data.entities;

import javax.persistence.*;

@Entity
@Table(name ="charity")
public class Charity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="charity_id")
    private int charity_id;

    @Column(name="charity_name")
    String charity_name;

    @Column(name="charity_nickname")
    String charity_nickname;

    @Column(name="charity_description")
    String charity_description;

    @Column(name = "charity_trending_rank")
    int charity_trending_rank;

    @Lob
    @Column(name = "charity_links")
    String charity_links;

    @Column(name = "charity_balance")
    double charity_balance;

    /* Required by JPA for building properly */
    public Charity() {
        super();
    }
    public Charity(String charity_name, String charity_nickname,
                   String charity_description, int charity_trending_rank,
                   String charity_links, double charity_balance)
    {
        this.charity_name = charity_name;
        this.charity_nickname = charity_nickname;
        this.charity_description= charity_description;
        this.charity_trending_rank = charity_trending_rank;
        this.charity_links = charity_links;
        this.charity_balance = charity_balance;
    }

    public int getCharity_id() {
        return charity_id;
    }

    public void setCharity_id(int user_id) {
        this.charity_id = charity_id;
    }

    public String getCharity_nickname() {
        return charity_nickname;
    }

    public void setCharity_nickname(String charity_nickname) {
        this.charity_nickname= charity_nickname;
    }

    public String getCharity_description() {
        return charity_description;
    }

    public void setCharity_description(String charity_description) {
        this.charity_description = charity_description;
    }

    public int getCharity_trending_rank() {
        return this.charity_trending_rank;
    }

    public void setCharity_trending_rank(int charity_trending_rank) {
        this.charity_trending_rank= charity_trending_rank;
    }


    public String getCharity_links() { return this.charity_links;}

    public void setCharity_links(String charity_links) {this.charity_links = charity_links;}

    public double getCharity_balance() {return this.charity_balance;}

    public void setCharity_balance(double charity_balance) {this.charity_balance = charity_balance;}


}
