package online.ludzh.contentcenter;

import online.ludzh.contentcenter.domain.dao.user.UserMapper;
import online.ludzh.contentcenter.domain.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by mi-ludzh on 0003 2019/11/3.
 */
@RestController
public class TestController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/test")
    public User testInsert(){
        User user = new User();
        user.setAvatarUrl("xxx");
        user.setBonus(100);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        this.userMapper.insertSelective(user);
        return user;
    }
}
