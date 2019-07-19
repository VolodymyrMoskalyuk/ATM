package com.test.atm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Table(name="users")
public class User {
    private Long id;
    private Integer username;
    private Integer password;
}
