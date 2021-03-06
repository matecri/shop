package com.example.shopmain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproduct")
    private Long idProduct;
    @Column(length = 255, nullable = false)
    private String img;
    @Column(length = 255, nullable = false)
    private String descrip;
    @Column(length = 25, nullable = false)
    private String brand;
    @Column(length = 10, nullable = false)
    private String color;
    @Column(nullable = false)
    private boolean mostrar;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_idtype")
    private Type type;

    public Product() {
    }

    public Product(String img, String descrip, String brand, String color, boolean mostrar, Type type) {
        this.img = img;
        this.descrip = descrip;
        this.brand = brand;
        this.color = color;
        this.mostrar = mostrar;
        this.type = type;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
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

    public boolean isMostrar() {
        return mostrar;
    }

    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
