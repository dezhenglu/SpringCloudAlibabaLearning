package online.ludzh.contentcenter.service.user;

import lombok.RequiredArgsConstructor;
import online.ludzh.contentcenter.domain.dao.user.UserMapper;
import online.ludzh.contentcenter.domain.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by mi-ludzh on 0003 2019/11/3.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    private final UserMapper userMapper;

    public User findById(Integer id){
        // select * from user where id = #{id}
        return this.userMapper.selectByPrimaryKey(id);
    }
}
