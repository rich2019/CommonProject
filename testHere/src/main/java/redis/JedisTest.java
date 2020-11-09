package redis;

import redis.clients.jedis.Jedis;

/**
 * @author 陈东东
 * @date 2020/10/30 14:13
 * @description 一句話描述用途
 */
public class JedisTest {

    public static void main(String[] args) {

    }

    private String getJedis() {
        Jedis jedis = null;
        try {
            jedis = null;
            jedis = RedisUtils.getJedis();
            if (null == jedis) {
                return "redis连接失败，请稍后重试";
            }
            // 设置key的值 过期
            String carHistory = "carHistory:";
            // key过期时间
            int expireTime = 24 * 60 * 60;

            // 如果存在重复数据就不上传
            if (jedis.exists(carHistory)) {
                // 如果重复,value值自增
                jedis.incr(carHistory);
                // 重置过期时间
                jedis.expire(carHistory, expireTime);
                return "重复上传";
            } else {
                // 将新数据存到redis中,并设置初始值为1,过期时间
                jedis.setex(carHistory, expireTime, "1");
            }
            return "未回收";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RedisUtils.returnResource(jedis);
            RedisUtils.returnBrokenResource(jedis);
        }


        return "执行了回收";
    }


}
