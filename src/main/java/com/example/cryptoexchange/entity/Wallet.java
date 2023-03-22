package com.example.cryptoexchange.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
//@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "wallets")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @NonNull
    private User user;

    @NonNull
    private double amountBitcoin;

    @NonNull
    private double amountTON;

    @NonNull
    private double amountDC;

    @NonNull
    private double amountRub;
}
