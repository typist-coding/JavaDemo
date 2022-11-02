package spring.controller;

import spring.service.UserService;
import spring.service.impl.UserServiceImpl;

/**
 * 接口不能交给IOC管理
 */

public class UserController {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser(){
        userService.saveUser();
    }
}
