package com.cariton.product.service;

import com.cariton.product.controller.dto.ProductDTO;
import com.cariton.product.domain.Product;
import com.cariton.product.mapper.ProductMapper;
import com.cariton.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO getProductById(String id) {
        return ProductMapper.mapEntityToDTO(
                productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No product with id: " + id)));
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> productsFromDB = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : productsFromDB) {
            productDTOS.add(ProductMapper.mapEntityToDTO(product));
        }

        return productDTOS;
    }

    @Override
    public void save(ProductDTO product) {
        productRepository.save(ProductMapper.mapDTOToEntity(product));
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.delete(getProduct(id));
    }

    private Product getProduct(String id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No product with id: " + id));
    }
}
