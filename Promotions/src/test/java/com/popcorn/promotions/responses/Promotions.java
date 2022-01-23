package com.popcorn.promotions.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Promotions {

    public List<PromotionDetails> promotions;

    public Promotions() {
    }

    public Promotions(List<PromotionDetails> promotions) {
        this.promotions = promotions;
    }

    public List<PromotionDetails> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<PromotionDetails> promotions) {
        this.promotions = promotions;
    }
}
