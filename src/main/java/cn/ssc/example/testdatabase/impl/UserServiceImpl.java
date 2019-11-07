package cn.ssc.example.testdatabase.impl;

import cn.ssc.example.testdatabase.interfaces.UserService;
import cn.ssc.example.testdatabase.mapper.UserMapper;
import cn.ssc.example.testdatabase.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Override
    public boolean isExist(String loginName, String password) {
        List<User> users = userMapper.findUsers(loginName, password);
        for (User user : users) {
            System.out.println("UserServiceImpl文件开始打印");
            System.out.println("loginName: " + user.getLoginName());
            System.out.println("password: " + user.getPassword());
        }
        return users.size() != 0;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
