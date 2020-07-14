package com.cariton.product.mapper;

import com.cariton.product.controller.dto.ProductDTO;
import com.cariton.product.domain.Product;

public class ProductMapper {

        private ProductMapper() {
        }

        public static ProductDTO mapEntityToDTO(Product product) {

            return ProductDTO.builder()
                    .price(product.getPrice())
                    .id(product.getId())
                    .name(product.getName())
                    .build();
        }

        public static Product mapDTOToEntity(ProductDTO productDTO) {

            return Product.builder()
                    .price(productDTO.getPrice())
                    .id(productDTO.getId())
                    .name(productDTO.getName())
                    .build();
        }
}
