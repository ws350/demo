package com.example.redis;

import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaoma
 * @desc ...
 * @date 2021-05-10 21:53:15
 */
public class RedisTest {
    public static void main(String[] args) {
        //new Jredis
        Jedis jedis = new Jedis("101.35.246.213",6379);
        //Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println(jedis.ping());
        System.out.println(jedis.exists("name"));
        RedisTemplate redisTemplate = new RedisTemplate();

        //分布式锁
        String lockkey = "lockkey";
        //用uuid标识不同的客户端，防止别的请求释放自己的锁
        //锁的value就是id
        String clientID = UUID.randomUUID().toString();
        Boolean result = redisTemplate.opsForValue().setIfAbsent(lockkey,clientID,10, TimeUnit.SECONDS);
        if(!result){
            //return "err_code";/锁被占用，也就是如果有人设置了lockkey 就意味这加锁了，需要解锁

        }
        try{
            int stock = Integer.parseInt((String) redisTemplate.opsForValue().get("stock"));//jedis.get
            if(stock >0){
                int realStock = stock -1;
                System.out.println("扣减成功，剩余库存："+ realStock);
            }else{
                System.out.println("扣减失败，库存不足");
            }
        }finally {
            if(clientID.equals(redisTemplate.opsForValue().get(lockkey))){
                redisTemplate.delete(lockkey);   //防止别人解锁，或者自己没解锁
            }
        }




    }
}
