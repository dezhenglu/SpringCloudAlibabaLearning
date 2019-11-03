package online.ludzh.contentcenter;

import online.ludzh.contentcenter.domain.dao.content.ShareMapper;
import online.ludzh.contentcenter.domain.entity.content.Share;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by mi-ludzh on 0003 2019/11/3.
 */
@RestController
public class TestController {

    @Autowired
    ShareMapper shareMapper;

    @GetMapping("/test")
    public List<Share> testInsert(){
        Share share = new Share();
        // 1. 插入
        share.setCreateTime(new Date());
        share.setUpdateTime(new Date());
        share.setTitle("xxx");
        share.setCover("xxx");
        share.setAuthor("加油");
        share.setBuyCount(1);
        shareMapper.insertSelective(share);
        // 2. 做查询; 查询当权数据库所有的share select * from share;
        List<Share> shares = this.shareMapper.selectAll();
        return shares;
    }
}
