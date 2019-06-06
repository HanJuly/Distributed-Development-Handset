package com.han.zuul;

import com.han.zuul.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/zuul")
public class TestController {
    @Autowired
    RedisUtil redisUtil;


    @RequestMapping("/testRedis")
    public String testRedisReq() {
        testRedis();
        return "ok";
    }

    private void testRedis() {

        Map<String, String> testMap = new HashMap();
        testMap.put("name", "han");
        testMap.put("age", "21");
        testMap.put("class", "一般");
        redisUtil.hmset("commonRedis", testMap);
    }
}
