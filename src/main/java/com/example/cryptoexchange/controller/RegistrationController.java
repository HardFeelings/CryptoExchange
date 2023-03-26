package com.example.cryptoexchange.controller;

import com.example.cryptoexchange.entity.User;
import com.example.cryptoexchange.entity.Wallet;
import com.example.cryptoexchange.repository.UserRepository;
import com.example.cryptoexchange.repository.WalletRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
@Slf4j
public class RegistrationController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    private WalletRepository walletRepository;

    public RegistrationController(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            WalletRepository walletRepository
    ) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.walletRepository = walletRepository;
    }

    @ModelAttribute(name = "user")
    public User user() {return new User();}

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(@ModelAttribute("user") @Valid User user,
                                      Errors errors,
                                      Model model,
                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("Неудачная попытка валидации с данными: {}", user.toString());
            model.addAttribute("message", "Ошибка валидации данных, проверьте правильность вводимых полей");
            return "registration";
        }
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Wallet newWallet = new Wallet();
            user.setWallet(newWallet);
            if (!userRepository.existsUserByUsername(user.getUsername())){
                walletRepository.save(newWallet);
                userRepository.save(user);
                log.info("Registered new user " + user);
            } else {
                model.addAttribute("err_message", "Такой пользователь уже существует!");
                return "registration";
            }

        } catch (Exception e) {
            log.info("can't save");
        }
        return "redirect:/login";

    }
}
