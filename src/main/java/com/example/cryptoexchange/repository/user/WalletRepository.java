package com.example.cryptoexchange.repository.user;

import com.example.cryptoexchange.entity.Wallet;
import org.springframework.data.repository.CrudRepository;

public interface WalletRepository extends CrudRepository<Wallet, Long> {
}
