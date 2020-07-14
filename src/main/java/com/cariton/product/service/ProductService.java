package com.cariton.product.service;

import com.cariton.product.controller.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO getProductById(String id);

    List<ProductDTO> getAllProducts();

    void save(ProductDTO product);

    void deleteProduct(String id);
}
