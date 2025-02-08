package com.project.shopapp.services;

import com.project.shopapp.dtos.ProductDTO;
import com.project.shopapp.dtos.ProductImageDTO;
import com.project.shopapp.exceptions.DataNotFoundException;
import com.project.shopapp.exceptions.InvalidParamException;
import com.project.shopapp.models.Category;
import com.project.shopapp.models.Product;
import com.project.shopapp.models.ProductImage;
import com.project.shopapp.repositories.CategoryRepository;
import com.project.shopapp.repositories.ProductImageRepository;
import com.project.shopapp.repositories.ProductRepository;
import com.project.shopapp.responses.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    private final ProductImageRepository productImageRepository;
    public ProductService(
            ProductImageRepository productImageRepository
            ,ProductRepository productRepository
            ,CategoryRepository categoryRepository
    )
    {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productImageRepository =productImageRepository;
    }
    @Override
    public Product createProduct(ProductDTO productDTO) throws DataNotFoundException{
        Category existingCategory = categoryRepository
                .findById(productDTO.getCategoryId())
                .orElseThrow(() ->
                        new DataNotFoundException(
                                "Cannot find category with id: "+productDTO.getCategoryId()));
        Product newProduct = new Product.Builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .thumbnail(productDTO.getThumbnail())
                .description(productDTO.getDescription())
                .category(existingCategory)
                .build();
        return productRepository.save(newProduct);
    }

    @Override
    public Product getProductById(long id) throws Exception {
        return productRepository.findById(id)
                .orElseThrow(() ->new DataNotFoundException("Cannot find product with id"+id));
    }
    @Override
    public Page<ProductResponse> getAllProducts(PageRequest pageRequest) {
       return productRepository
               .findAll(pageRequest)
               .map(ProductResponse::fromProduct);
    };
    @Override
    public Product updateProduct(
            long id,
            ProductDTO productDTO) throws Exception {
        Product existingProduct = getProductById(id);
        if(existingProduct!= null){
            //Copy các thuộc tính từ DTO --> Product
            // CÓ thể sử dụng ModolMapper
            Category existingCategory = categoryRepository
                    .findById(productDTO.getCategoryId())
                    .orElseThrow(() ->
                            new DataNotFoundException(
                                    "Cannot find category with id: "+productDTO.getCategoryId()));
            existingProduct.setName(productDTO.getName());
            existingProduct.setCategory(existingCategory);
            existingProduct.setPrice(productDTO.getPrice());
            existingProduct.setDescription(productDTO.getDescription());
            existingProduct.setThumbnail(productDTO.getThumbnail());
            return productRepository.save(existingProduct);

        }
        return null;
    }

    @Override
    public void deleteProduct(long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        optionalProduct.ifPresent(productRepository::delete);
    }

    @Override
    public boolean existsByName(String name) {
        return productRepository.existsByName(name);
    }

    @Override
    public List<Product> findProductsByIds(List<Long> productIds) {
        return null;
    }
    @Override
    public ProductImage createProductImage(
            Long productId,
            ProductImageDTO productImageDTO
    ) throws Exception {
        Product existingProduct = productRepository
                .findById(productId)
                .orElseThrow(() ->
                        new DataNotFoundException(
                                "Cannot find category with id: "+productImageDTO.getProductId()));
        ProductImage newProductImage = new ProductImage.Builder()
                .product(existingProduct)
                .imageUrl(productImageDTO.getImageUrl())
                .build();
        // Không cho insert quá 5 ảnh cho 1 sản phẩm
        int size = productImageRepository.findByProductId(productId).size();
        if(size>=ProductImage.MAXIMUM_IMAGES_PER_PRODUCT){
            throw new InvalidParamException("Ảnh phải nhỏ hơn hoặc bằng "+ProductImage.MAXIMUM_IMAGES_PER_PRODUCT);

        }
       return productImageRepository.save(newProductImage);
    }
}
