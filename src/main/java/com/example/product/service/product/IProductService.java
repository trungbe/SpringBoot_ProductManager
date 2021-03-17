package com.example.product.service.product;

import com.example.product.model.Product;
import com.example.product.service.IService;

import java.util.List;

public interface IProductService extends IService<Product> {
    List<Product> findByCategoryName(Long id);
    List<Product> top5ProductPriceMax();
    List<Product> top5ProductNewest();
    long sumPrice();

}
