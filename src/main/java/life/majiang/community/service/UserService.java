package life.majiang.community.service;

import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.User;
import life.majiang.community.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author c_sir
 * @create 2020-03-23 12:55
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andTokenEqualTo(user.getAccountId());
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() == 0){
            //数据库中没有此用户，插入此用户到数据库
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
        }else{
            //数据库中有此用户，更新此用户信息
            User dbUser = users.get(0);
            User updateUser = new User();
            updateUser.setAvatarUrl(user.getAvatarUrl());
            updateUser.setGmtModified(System.currentTimeMillis());
            updateUser.setName(user.getName());
            updateUser.setToken(user.getToken());
            UserExample example = new UserExample();
            example.createCriteria().andIdEqualTo(dbUser.getId());
            userMapper.updateByExampleSelective(updateUser, example);
        }
    }
}
