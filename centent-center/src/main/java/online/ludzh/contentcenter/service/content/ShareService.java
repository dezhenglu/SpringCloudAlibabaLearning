package online.ludzh.contentcenter.service.content;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online.ludzh.contentcenter.domain.dao.content.ShareMapper;
import online.ludzh.contentcenter.domain.dto.content.ShareDTO;
import online.ludzh.contentcenter.domain.dto.user.UserDTO;
import online.ludzh.contentcenter.domain.entity.content.Share;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by mi-ludzh on 0003 2019/11/3.
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareService {

    private final ShareMapper shareMapper;

    private final RestTemplate restTemplate;

    private final DiscoveryClient discoveryClient;

    public ShareDTO findById(Integer id){
        // 获取分享详情
        Share share = this.shareMapper.selectByPrimaryKey(id);
        // 发布人id
        Integer userId = share.getUserId();

        List<ServiceInstance> instances = discoveryClient.getInstances("user-center");

        String targetURL = instances.stream()
                .map(instance -> instance.getUri().toString() + "/users/{id}")
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("当前没有实例"));
        log.info("请求的目标地址:{}", targetURL);
        UserDTO userDTO = this.restTemplate.getForObject(
                targetURL,
                UserDTO.class, userId
        );

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
