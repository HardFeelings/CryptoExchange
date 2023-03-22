package com.example.cryptoexchange.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "wallet")
public class Wallet {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private double amountBitcoin;

    @NonNull
    private double amountTON;

    @NonNull
    private double amountDC;

    @NonNull
    private double amountRub;
}
