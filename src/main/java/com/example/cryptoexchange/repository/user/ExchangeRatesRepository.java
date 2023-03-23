package com.example.cryptoexchange.repository.user;

import com.example.cryptoexchange.entity.ExchangeRates;
import org.springframework.data.repository.CrudRepository;

public interface ExchangeRatesRepository extends CrudRepository<ExchangeRates,Long> {
    ExchangeRates findExchangeRatesById(Long id);
}
