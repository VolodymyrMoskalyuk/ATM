package com.test.atm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Account {
    private Long id;
    private User user;
    private Long amountOfMoney;
}
