package com.test.atm.service.impl;

import com.test.atm.dao.UserRepository;
import com.test.atm.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static com.test.atm.model.Role.CLIENT;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final String INVALID_MSG = "Wrong login or password!!!";

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(Long.valueOf(username));

        if (user == null) {
            throw new UsernameNotFoundException(INVALID_MSG);
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername().toString(),
                user.getPassword().toString(), getAuthority());
    }

    private Set<? extends GrantedAuthority> getAuthority() {
        Set<SimpleGrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(CLIENT.getAuthority()));
        return roles;
    }
}


