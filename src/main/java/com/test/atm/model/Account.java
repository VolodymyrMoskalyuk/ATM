package com.test.atm.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
@Builder
public class Account {
    private Long id;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @Column(name = "account_number")
    private Long accountNumber;
    @Column(name = "amount")
    private BigDecimal amountOfMoney;
}
