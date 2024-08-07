package com.euphoria_ecommerce.controller;

import com.euphoria_ecommerce.dto.RecentlyViewedProductsDto;
import com.euphoria_ecommerce.service.RecentlyViewedProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viewed")
@RequiredArgsConstructor
public class RecentlyViewedProductsController {
    private final RecentlyViewedProductsService viewedProductsService;

    @GetMapping("/{id}")
    public ResponseEntity<RecentlyViewedProductsDto> getViewedProductById(@PathVariable int id) {
        return new ResponseEntity<>(viewedProductsService.getViewedProductById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<RecentlyViewedProductsDto>> getAllViewedProducts() {
        return new ResponseEntity<>(viewedProductsService.getAllViewedProducts(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<RecentlyViewedProductsDto> createViewedProduct(@RequestBody RecentlyViewedProductsDto viewedProducts) {
        return new ResponseEntity<>(viewedProductsService.createViewedProduct(viewedProducts), HttpStatus.CREATED);
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<RecentlyViewedProductsDto> updateViewedProduct(@PathVariable int id, @RequestBody RecentlyViewedProductsDto viewedProducts) {
//        return new ResponseEntity<>(viewedProductsService.updateViewedProducts(id, viewedProducts), HttpStatus.CREATED);
//    }
}
