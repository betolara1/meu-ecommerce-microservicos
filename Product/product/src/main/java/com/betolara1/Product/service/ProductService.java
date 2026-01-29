package com.betolara1.Product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betolara1.Product.dto.ProductDTO;
import com.betolara1.Product.model.Product;
import com.betolara1.Product.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProducts(){
        return productRepository.findAll()
            .stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public ProductDTO getProductById (Long id){
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return new ProductDTO(product);
    }

    public Product updateProduct(Long id, Product updateProduct){
        Product findProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        findProduct.setSku(updateProduct.getSku());
        findProduct.setName(updateProduct.getName());
        findProduct.setDescription(updateProduct.getDescription());
        findProduct.setPrice(updateProduct.getPrice());
        findProduct.setCategoryId(updateProduct.getCategoryId());
        findProduct.setImageUrl(updateProduct.getImageUrl());
        findProduct.setActive(updateProduct.isActive());

        return productRepository.save(findProduct);
    }

    public void deleteProduct(Long id){
        Product findProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(findProduct);
    }
}
