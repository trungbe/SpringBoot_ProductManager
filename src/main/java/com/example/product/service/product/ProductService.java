package com.example.product.service.product;

import com.example.product.exception.NotFoundException;
import com.example.product.model.Product;
import com.example.product.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findALl() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> findALl(Pageable pageable) {
        return productRepository.findAllByOrderByIdAsc(pageable);
    }

    @Override
    public Product findById(Long id) throws NotFoundException {
        Product product = productRepository.findById(id).get();
        if (product != null) {
            return product;
        } else throw new NotFoundException();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findProductName(name);
    }

    @Override
    public List<Product> findByCategoryName(Long id) {
        return productRepository.findProductByCategoryName(id);
    }

    @Override
    public List<Product> top5ProductPriceMax() {
        return productRepository.findTop5ByOrderByPriceDesc(5);
    }

    @Override
    public List<Product> top5ProductNewest() {
        return productRepository.findTop5ByOrderByDatetimeDesc();
    }

    @Override
    public long sumPrice() {
        return productRepository.sumPrice();
    }

}
