package com.juan.microservice.currencyconvertionservice;

import java.math.BigDecimal;

public class CurrencyConvertion {

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private BigDecimal quatity;
    private BigDecimal totalClaculatedAmount;
    private String environment;

    public CurrencyConvertion(Long id, String from, String to, BigDecimal quatity, BigDecimal conversionMultiple, BigDecimal totalClaculatedAmount, String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.quatity = quatity;
        this.conversionMultiple = conversionMultiple;
        this.totalClaculatedAmount = totalClaculatedAmount;
        this.environment = environment;
    }

    public CurrencyConvertion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public BigDecimal getQuatity() {
        return quatity;
    }

    public void setQuatity(BigDecimal quatity) {
        this.quatity = quatity;
    }

    public BigDecimal getTotalClaculatedAmount() {
        return totalClaculatedAmount;
    }

    public void setTotalClaculatedAmount(BigDecimal totalClaculatedAmount) {
        this.totalClaculatedAmount = totalClaculatedAmount;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
