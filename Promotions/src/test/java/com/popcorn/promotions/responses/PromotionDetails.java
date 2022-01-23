package com.popcorn.promotions.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PromotionDetails {

    private String promotionId;

    private String orderId;

    private String[] promoArea;

    private String promoType;

    private String showPrice;

    private String showText;

    private HashMap<String, List> localizedTexts;

    private List<HashMap<String, Object>> properties;

    private List<HashMap<String, Object>> images;


    public PromotionDetails() {
    }

    public PromotionDetails(String promotionId, String orderId, String[] promoArea, String promoType, String showPrice, String showText, HashMap<String, List> localizedTexts, List<HashMap<String, Object>> properties) {
        this.promotionId = promotionId;
        this.orderId = orderId;
        this.promoArea = promoArea;
        this.promoType = promoType;
        this.showPrice = showPrice;
        this.showText = showText;
        this.localizedTexts = localizedTexts;
        this.properties = properties;
    }


    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String[] getPromoArea() {
        return promoArea;
    }

    public void setPromoArea(String[] promoArea) {
        this.promoArea = promoArea;
    }

    public String getPromoType() {
        return promoType;
    }

    public void setPromoType(String promoType) {
        this.promoType = promoType;
    }

    public String getShowPrice() {
        return showPrice;
    }

    public void setShowPrice(String showPrice) {
        this.showPrice = showPrice;
    }

    public String getShowText() {
        return showText;
    }

    public void setShowText(String showText) {
        this.showText = showText;
    }

    public HashMap<String, List> getLocalizedTexts() {
        return localizedTexts;
    }

    public void setLocalizedTexts(HashMap<String, List> localizedTexts) {
        this.localizedTexts = localizedTexts;
    }

    public List<HashMap<String, Object>> getProperties() {
        return properties;
    }

    public void setProperties(List<HashMap<String, Object>> properties) {
        this.properties = properties;
    }

    public List<HashMap<String, Object>> getImages() {
        return images;
    }

    public void setImages(List<HashMap<String, Object>> images) {
        this.images = images;
    }
}
