package com.example.shopmain.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class ProductDto {


    private String img;
    private String descrip;
    private String brand;
    private String color;
    private Boolean mostrar;
    private Long type;

    public ProductDto() {
    }

    public ProductDto(String img, String descrip, String brand, String color, Boolean mostrar, Long type) {
        this.img = img;
        this.descrip = descrip;
        this.brand = brand;
        this.color = color;
        this.mostrar = mostrar;
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getMostrar() {
        return mostrar;
    }

    public void setMostrar(Boolean mostrar) {
        this.mostrar = mostrar;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }
}
