package com.juan.microservice.currencyconvertionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrencyConvertionController {

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("/currency-convertion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConvertion calculateCurrencyConvertion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConvertion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConvertion.class, uriVariables);
        CurrencyConvertion currencyConvertion = responseEntity.getBody();

        return new CurrencyConvertion(currencyConvertion.getId(),
                from, to, quantity,
                currencyConvertion.getConversionMultiple(),
                quantity.multiply(currencyConvertion.getConversionMultiple()),
                currencyConvertion.getEnvironment());
    }

    @GetMapping("/currency-convertion-feing/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConvertion calculateCurrencyConvertionFeing(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        CurrencyConvertion currencyConvertion = currencyExchangeProxy.retrieveExchangeValue(from, to);

        return new CurrencyConvertion(currencyConvertion.getId(),
                from, to, quantity,
                currencyConvertion.getConversionMultiple(),
                quantity.multiply(currencyConvertion.getConversionMultiple()),
                currencyConvertion.getEnvironment());
    }


}
