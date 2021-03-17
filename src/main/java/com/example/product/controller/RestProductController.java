package com.example.product.controller;

import com.example.product.exception.NotFoundException;
import com.example.product.model.Category;
import com.example.product.model.Product;
import com.example.product.service.category.ICategoryService;
import com.example.product.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/products")
public class RestProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findALl();
    }

    //show
    @GetMapping()
    public ResponseEntity<Iterable<Product>> findAll() {
        return new ResponseEntity<>(productService.findALl(), HttpStatus.OK);
    }

    @GetMapping("/list")
//    public ModelAndView getList(@PageableDefault(size = 3) Pageable pageable) {
//        Page<Product> products = productService.findALl(pageable);
//        ModelAndView modelAndView = new ModelAndView("listProduct");
//        modelAndView.addObject("list",products);
//        return modelAndView;
//    }
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView("listProduct");
        modelAndView.addObject("list", productService.findALl());
        return modelAndView;
    }

    //create
    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //findId
    @GetMapping("/{id}")
    public ResponseEntity<Product> getOneProduct(@PathVariable Long id) throws NotFoundException {
        Product p;
        p = productService.findById(id);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    //update
    @PutMapping("/{id}")
    public ResponseEntity<Product> editProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        productService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
