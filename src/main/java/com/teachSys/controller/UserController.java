package com.teachSys.controller;

import com.teachSys.common.JsonData;
import com.teachSys.entity.User;
import com.teachSys.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

/**
 * UserController
 *
 * @author Eric
 * @date 2017/12/5
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @RequestMapping("/getAllUser")
    @ResponseBody
    public User getAllUser() {
        List<User> userList = userService.getAllUser();

        logger.info(String.valueOf(userList));
        //System.out.println(userList);
        return null;
    }

    @RequestMapping("/getByUserName")
    @ResponseBody
    public User getByUserName() {
        return userService.getByUserName("eric");
    }

    @RequestMapping("/register")
    public Boolean register(String userName,String password,String againPassword) {
        if (!password.equals(againPassword)){
            return false;
        }

        String md5Password = new SimpleHash("MD5", password, userName).toString();

        //userService.insert(new User(UUID.randomUUID().toString().replaceAll("-",""),userName,md5Password));
        return true;
    }

    @RequestMapping("/login")
    @ResponseBody
    public JsonData login(User user, HttpServletRequest request) {
        Subject currentUser = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), new SimpleHash("MD5",user.getPassword(),user.getUserName()).toString());
        try {
            currentUser.login(token);
            return JsonData.success("登陆成功");
        } catch (Exception e) {
            return JsonData.fail("登录失败");
        }
    }
}
