package com.example.shopmain.service;

import com.example.shopmain.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    public List<Product> list();
    public Optional<Product> getOne(Long id);
    public Product getBydescrip(String descrip);
    public void save(Product product);
    public boolean exitid(Long id);
    public boolean existsBydescrip(String descrip);
    public void registerProduct(Product product);
    public Product getBybrand(String brand);
    public boolean existsBybrand(String brand);
    public Product getBycolor(String color);
    public boolean existsBycolor(String color);
}
