package com.example.cryptoexchange.forms;

import com.example.cryptoexchange.entity.User;
import com.example.cryptoexchange.entity.Wallet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationForm {

    @NonNull
    @Size(min = 5, message = "Логин должен содержать минимум 5 символов")
    private String username;

    @NonNull
    @Size(min = 6, message = "Пароль должен содержать минимум 6 символов")
    private String password;


    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password), new Wallet());
    }
}
