package com.example.quizapplication.Models;

import java.io.Serializable;

public class BienBao implements Serializable {
    int id;
    String image;
    String name;
    String noidung;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public BienBao(int id, String name, String image , String noidung) {
        this.id = id;
        this.name = name;
        this.image = image;

        this.noidung = noidung;
    }
}
