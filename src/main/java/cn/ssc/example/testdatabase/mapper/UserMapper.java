package cn.ssc.example.testdatabase.mapper;

import cn.ssc.example.testdatabase.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserMapper {
    List<User> findUsers(@Param("loginName") String loginName, @Param("password") String password);
}
