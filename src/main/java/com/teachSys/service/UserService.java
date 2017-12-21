package com.teachSys.service;

import com.teachSys.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    User getUsers(String userId);

    User getByUserName(String userName);

    Set<String> getRoles(String userName);

    Set<String> getPermissions(String userName);

    int insert(User record);

    List<User> getAllUser();
}