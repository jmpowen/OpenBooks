package com.example.business.data.entities;

import javax.persistence.*;

@Entity
@Table(name ="image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="image_id")
    private int image_id;

    @Column(name="charity_id")
    int charity_id;

    @Lob
    @Column(name="image")
    Byte[] image;

    @Column(name="image_description")
    String image_description;

    @Column(name = "image_category")
    String image_category;


    public int getImage_id() {return this.image_id;}

    public void setImage_id(int image_id) {this.image_id = image_id;}

    public int getImageCharity_Id() {return this.charity_id;}

    public void setImageCharity_Id(int charity_id) {this.image_id = image_id;}

    public Byte[] getImage() {return this.image;}

    public void setImage(Byte[] image) {this.image = image;}

    public String getImage_description() {return this.image_description;}

    public void setImage_description(String image_description) { this.image_description = image_description;}

    public String getImage_category() {return this.image_category;}

    public void setImage_category(String image_category) {this.image_category = image_category;}



}