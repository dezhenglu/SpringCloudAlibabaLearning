package online.ludzh;

import org.springframework.web.client.RestTemplate;

/**
 * Created by ludzh on 2019/11/14.
 */
public class SentinelTest {

//    public static void main1(String[] args) throws InterruptedException {
//        RestTemplate restTemplate = new RestTemplate();
//        for (int i = 0; i < 10000; i++){
//            String object = restTemplate
//                    .getForObject("http://localhost:8010/test-b", String.class);
//            Thread.sleep(500);
//        }
//    }
//
    public static void main(String[] args) throws InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        for (int i = 0; i < 10000; i++){
            String object = restTemplate
                    .getForObject("http://localhost:8010/test-a", String.class);
            System.out.println("---" + object + "---");
        }
    }

    public static void main1(String[] args) throws InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        for (int i = 0; i < 10000; i++){
            String object = restTemplate
                    .getForObject("http://localhost:8010/actuator/sentinel", String.class);
            Thread.sleep(500);
        }
    }

}
