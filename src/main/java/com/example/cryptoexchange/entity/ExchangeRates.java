package com.example.cryptoexchange.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
@Entity
@Table(name = "exchange_rates")
public class ExchangeRates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    public double bitcoinRate;
    @NonNull
    public double tonRate;
    @NonNull
    public double dcRate;
}
