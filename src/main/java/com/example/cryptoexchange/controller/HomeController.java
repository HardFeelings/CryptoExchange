package com.example.cryptoexchange.controller;

import com.example.cryptoexchange.entity.ExchangeRates;
import com.example.cryptoexchange.entity.User;
import com.example.cryptoexchange.entity.Wallet;
import com.example.cryptoexchange.repository.ExchangeRatesRepository;
import com.example.cryptoexchange.repository.UserRepository;
import com.example.cryptoexchange.repository.WalletRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
@Controller
public class HomeController {

    final ExchangeRatesRepository exchangeRatesRepository;
    final WalletRepository walletRepository;
    final UserRepository userRepository;

    public HomeController(ExchangeRatesRepository exchangeRatesRepository, WalletRepository walletRepository, UserRepository userRepository) {
        this.exchangeRatesRepository = exchangeRatesRepository;
        this.walletRepository = walletRepository;
        this.userRepository = userRepository;
    }

    @ModelAttribute("exchangeRates")
    public ExchangeRates exchangeRates() {
        return exchangeRatesRepository.findFirstById(1L);
    }

    @ModelAttribute("authUser")
    public User user(@AuthenticationPrincipal User user) {
        return user;
    }

    @ModelAttribute("authWallet")
    public Wallet wallet(@AuthenticationPrincipal User user) {
        return user.getWallet();
    }

    @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/home/buy")
    public String buy() {


        return "buy";
    }

}
