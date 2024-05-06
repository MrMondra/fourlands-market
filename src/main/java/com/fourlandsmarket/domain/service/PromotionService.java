package com.fourlandsmarket.domain.service;

import com.fourlandsmarket.domain.dto.Promotion;
import com.fourlandsmarket.domain.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionService {

    @Autowired
    PromotionRepository promotionRepository;

    @Transactional(readOnly = true)
    public List<Promotion> getAll() {
        return promotionRepository.getAll();
    }

    @Transactional(readOnly = true)
    public Optional<List<Promotion>> getPromotionByNameCategory(String nameCategory) {
        return promotionRepository.getPromotionByNameCategory(nameCategory);
    }
}
