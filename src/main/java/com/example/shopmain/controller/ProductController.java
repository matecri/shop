package com.example.shopmain.controller;

import com.example.shopmain.dto.Mensaje;
import com.example.shopmain.dto.ProductDto;
import com.example.shopmain.entity.Product;
import com.example.shopmain.service.IProductService;
import com.example.shopmain.service.ITypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService IProductService;
    @Autowired
    ITypeService iTypeService;
    @GetMapping()
    public ResponseEntity<List<Product>> list(){
        List<Product> list = IProductService.list();
        return ResponseEntity.ok(list);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductDto productDto){
        if(StringUtils.isAllBlank(productDto.getBrand())){
            return new ResponseEntity(new Mensaje("la marca es obligatoria"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isAllBlank(productDto.getDescrip())){
            return new ResponseEntity(new Mensaje("la Descripcion es obligatoria"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isAllBlank(productDto.getImg())){
            return new ResponseEntity(new Mensaje("Por favor suba una imagen de producto"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isAllBlank(productDto.getColor())){
            return new ResponseEntity(new Mensaje("el color es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if(productDto.getMostrar()==null){
            return new ResponseEntity(new Mensaje("error en campo mostrar"),HttpStatus.BAD_REQUEST);
        }
        if(IProductService.existsBydescrip(productDto.getDescrip()) && IProductService.existsBybrand(productDto.getBrand()) && IProductService.existsBycolor(productDto.getColor())){
            return new ResponseEntity(new Mensaje("ya existe un producto con las mismas caracteristicas"),HttpStatus.BAD_REQUEST);
        }
        if (productDto.getType()==null){
            return new ResponseEntity(new Mensaje("eliga un tipo"),HttpStatus.BAD_REQUEST);
        }
        if(!iTypeService.existbyid(productDto.getType())){
            return new ResponseEntity(new Mensaje("el tipo no existe"),HttpStatus.BAD_REQUEST);
        }


        Product product =new Product(productDto.getImg(),productDto.getDescrip(),productDto.getBrand(),productDto.getColor(),productDto.getMostrar(),iTypeService.getOne(productDto.getType()).get());
         IProductService.save(product);
          return new ResponseEntity(new Mensaje("Producto Creado"),HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")Long id,@RequestBody ProductDto productDto){
        if(!IProductService.exitid(id)){
            return new ResponseEntity(new Mensaje("el producto no existe"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isAllBlank(productDto.getBrand())){
            return new ResponseEntity(new Mensaje("la marca es obligatoria"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isAllBlank(productDto.getDescrip())){
            return new ResponseEntity(new Mensaje("la Descripcion es obligatoria"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isAllBlank(productDto.getImg())){
            return new ResponseEntity(new Mensaje("Por favor suba una imagen de producto"),HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isAllBlank(productDto.getColor())){
            return new ResponseEntity(new Mensaje("el color es obligatorio"),HttpStatus.BAD_REQUEST);
        }
        if(productDto.getMostrar()==null){
            return new ResponseEntity(new Mensaje("error en campo mostrar"),HttpStatus.BAD_REQUEST);
        }
        Product product = IProductService.getOne(id).get();

        product.setBrand(productDto.getBrand());
        product.setDescrip(productDto.getDescrip());
        product.setImg(productDto.getImg());
        product.setColor(productDto.getColor());
        product.setMostrar(productDto.getMostrar());

        IProductService.save(product);
        return new ResponseEntity(new Mensaje("Producto actualizado"),HttpStatus.OK);
    }
}
