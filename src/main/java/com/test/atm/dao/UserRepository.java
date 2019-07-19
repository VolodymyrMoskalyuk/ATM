package com.test.atm.dao;

import com.test.atm.model.User;

public interface UserRepository {

   User findByUsername(Integer username);

}
