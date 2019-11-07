package cn.ssc.example.testdatabase.controller;

import cn.ssc.example.testdatabase.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/requestAction")
public class Request {
    private UserService userService;

    @RequestMapping("/findUser")
    @ResponseBody
    public boolean findUser(String loginName, String password) {
        return userService.isExist(loginName, password);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
