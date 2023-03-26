package com.example.cryptoexchange.config;

import com.example.cryptoexchange.entity.ExchangeRates;
import com.example.cryptoexchange.repository.ExchangeRatesRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    @Bean
    public ApplicationRunner dataLoader(ExchangeRatesRepository exchangeRatesRepository) {
        return args -> {
            exchangeRatesRepository.save(new ExchangeRates(1L, 3000, 4000, 9000));
        };
    }
}
