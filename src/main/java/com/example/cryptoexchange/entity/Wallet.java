package com.example.cryptoexchange.entity;


import lombok.*;

import javax.persistence.*;


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

    @OneToOne(optional = false, mappedBy="wallet")
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
