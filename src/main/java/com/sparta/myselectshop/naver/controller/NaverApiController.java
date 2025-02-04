package com.sparta.myselectshop.naver.controller;


import com.sparta.myselectshop.dto.ProductResponseDto;
import com.sparta.myselectshop.naver.dto.ItemDto;
import com.sparta.myselectshop.naver.dto.ProductMypriceRequestDto;
import com.sparta.myselectshop.naver.service.NaverApiService;
import com.sparta.myselectshop.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class NaverApiController {

    private final NaverApiService naverApiService;
    private final ProductService productService;

    @GetMapping("/search")
    public List<ItemDto> searchItems(@RequestParam String query)  {
        return naverApiService.searchItems(query);
    }

    @PutMapping("/products/{id}")
    public ProductResponseDto updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto productMypriceRequestDto) {
        return  productService.updateProduct(id, productMypriceRequestDto);
    }

    @GetMapping("/products")
    public List<ProductResponseDto> getProducts() {
        return productService.getProduct();
    }
}