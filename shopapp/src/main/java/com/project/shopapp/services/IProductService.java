package com.project.shopapp.services;

import com.project.shopapp.dtos.ProductDTO;

import com.project.shopapp.dtos.ProductImageDTO;
import com.project.shopapp.exceptions.DataNotFoundException;
import com.project.shopapp.models.Product;
import com.project.shopapp.models.ProductImage;
import com.project.shopapp.responses.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IProductService {
    Product createProduct(ProductDTO productDTO) throws DataNotFoundException;
    Product getProductById(long id) throws Exception;
    Product updateProduct(long id, ProductDTO productDTO) throws Exception;
    void deleteProduct(long id);
    boolean existsByName(String name);
    List<Product> findProductsByIds(List<Long> productIds);
    Page<ProductResponse> getAllProducts(PageRequest pageRequest);
    ProductImage createProductImage(
            Long productId,
            ProductImageDTO productImageDTO
    ) throws Exception;
}
