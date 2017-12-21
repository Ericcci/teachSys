package com.teachSys.dao.mapper;

import com.teachSys.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserMapper {

    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getByUserName(String userName);

    Set<String> getRoles(String userName);

    Set<String> getPermissions(String userName);

    List<User> getAllUser();
}