package com.teachSys.service.impl;

import com.teachSys.dao.mapper.UserMapper;
import com.teachSys.entity.User;
import com.teachSys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * UserServiceImpl
 *
 * @author Eric
 * @date 2017/12/5
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUsers(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public User getByUserName(String userName) {
       return userMapper.getByUserName(userName);
    }

    public Set<String> getRoles(String userName) {
        return userMapper.getRoles(userName);
    }

    public Set<String> getPermissions(String userName) {
        return userMapper.getPermissions(userName);
    }

    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Cacheable(value="common")
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

}
