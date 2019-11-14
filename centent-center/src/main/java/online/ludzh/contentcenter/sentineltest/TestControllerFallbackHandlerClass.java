package online.ludzh.contentcenter.sentineltest;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by ludzh on 2019/11/15.
 */
@Slf4j
public class TestControllerFallbackHandlerClass {
    /**
     * 处理降级
     * @param a
     * @param e
     * @return
     */
    public static String fallback(String a, Throwable e){
        log.warn("限流, 或者降级了" , e);
        return "限流, 或者降级了 fallback";
    }
}
