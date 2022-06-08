package com.product.controller;

import com.product.dto.ProductDTO;
import com.product.dto.ResponseAllProducts;
import com.product.dto.ResponseDTO;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    // create a product
    @PostMapping("/product")
    public ResponseEntity<ResponseDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ResponseDTO responseDTO = productService.createProduct(productDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // update a product
    @PatchMapping("/product")
    public ResponseEntity<ResponseDTO> updateProduct(@RequestBody ProductDTO productDTO) {
        ResponseDTO responseDTO = productService.updateProduct(productDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // delete a product
    @DeleteMapping("/product")
    public ResponseEntity<ResponseDTO> deleteProduct(@RequestParam String productId) {
        ResponseDTO responseDTO = productService.deleteProduct(productId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // 4. Retrieve all the products in a given category
    // (input: product category name)
//    output: result (list of product data including name, description,
//                    price, product category,product comments [if any]),
//    status (success / error).
    @GetMapping("/listAllProducts")
    public ResponseEntity<ResponseAllProducts> getProductList(@RequestParam String categoryId) {
        ResponseAllProducts responseDTO = productService.getProductList(categoryId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    //    5. Retrieve all premium products (products whose price is more than or
//            equal to $500)
//    output: result (list of product data including name, description,
//                    price, product category, product comments [if any]),
//    status (success / error)
//    @GetMapping("/listAllPremiumProducts")
//    public ResponseEntity<ResponseDTO> listAllPremiumProducts(@RequestParam String categoryId) {
//        ResponseDTO responseDTO = productService.listAllPremiumProducts(categoryId);
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//    }
    @GetMapping("/listAllPremiumProducts")
    public ResponseEntity<ResponseAllProducts> getPremiumProductList(@RequestParam String categoryId) {
        ResponseAllProducts responseDTO = productService.getPremiumProductList(categoryId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }



}
