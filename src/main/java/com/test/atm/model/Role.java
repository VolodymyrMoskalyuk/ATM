package com.test.atm.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    CLIENT;

    @Override
    public String getAuthority() {
        return name();
    }
}
