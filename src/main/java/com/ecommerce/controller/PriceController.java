package com.ecommerce.controller;

import com.ecommerce.dto.PriceApi;
import com.ecommerce.mapper.PriceMapper;
import com.ecommerce.service.PriceService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("v1/ecommerce/price/")
@AllArgsConstructor
public class PriceController {

    private final PriceMapper mapper;
    private final PriceService priceService;

    @GetMapping
    private ResponseEntity<PriceApi> findPriceBy(
            @RequestParam(name = "application_date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") final LocalDateTime applicationDate,
            @RequestParam(name = "product_id") final Long productId,
            @RequestParam(name = "brand_id")  final Long brandId) {
        return ResponseEntity.ok(mapper.toPriceApi(priceService.findPriceBy(applicationDate, productId, brandId)));
    }
}