package com.ecommerce.service;

import com.ecommerce.exception.PriceNotFoundException;
import com.ecommerce.model.Price;
import com.ecommerce.repository.PriceRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@AllArgsConstructor
public class PriceService {

    private final PriceRepository priceRepository;

    public Price findPriceBy(final LocalDateTime applicationDate, final Long productId, final Long brandId) {
        log.info("Searching price by applicationDate: {}, productId: {}, brandId: {} ", applicationDate, productId, brandId);
        return priceRepository.findPricesBy(productId, brandId, applicationDate).orElseThrow(() -> new PriceNotFoundException("Price not found"));
    }
}