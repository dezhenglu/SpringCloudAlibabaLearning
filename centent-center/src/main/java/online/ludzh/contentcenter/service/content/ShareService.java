package online.ludzh.contentcenter.service.content;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online.ludzh.contentcenter.domain.dao.content.ShareMapper;
import online.ludzh.contentcenter.domain.dto.content.ShareDTO;
import online.ludzh.contentcenter.domain.dto.user.UserDTO;
import online.ludzh.contentcenter.domain.entity.content.Share;
import online.ludzh.contentcenter.feignclient.UserCenterFeignClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Created by mi-ludzh on 0003 2019/11/3.
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareService {

    private final ShareMapper shareMapper;

    private final UserCenterFeignClient userCenterFeignClient;

    public ShareDTO findById(Integer id){
        // 获取分享详情
        Share share = this.shareMapper.selectByPrimaryKey(id);
        // 发布人id
        Integer userId = share.getUserId();

        // 1. 代码不可读
        // 2. 复杂的url难以维护: https://user-center/s?ie={ie}&chrome={c}.....
        // 3. 难以响应需求变化, 变化很没有幸福感
        // 4. 变成体验不统一
        UserDTO userDTO = userCenterFeignClient.findById(userId);

        // 消息的装配
        ShareDTO shareDTO = new ShareDTO();
        BeanUtils.copyProperties(share, shareDTO);
        shareDTO.setWxNickName(userDTO.getWxNickname());
        return shareDTO;
    }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject(
                "http://localhost:8080/users/{id}",
                String.class, 1
        );

        ResponseEntity<String> forEntity = restTemplate.getForEntity(
                "http://localhost:8080/users/{id}",
                String.class, 1
        );

        System.out.println(forObject);

        System.out.println(forEntity.getStatusCode());
        System.out.println(forEntity.getBody());
    }
}
