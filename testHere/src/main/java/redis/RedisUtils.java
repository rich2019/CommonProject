package redis;

import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangxiaoqiang
 * @date 2015-7-15 下午10:15:41
 * @description redis工具类
 */

public class RedisUtils {
    public static Logger log = Logger.getLogger(RedisUtils.class);

    private static JedisPool pool = null;

    private static ReentrantLock poolLock = new ReentrantLock();
    private static ReentrantLock poolLockNew = new ReentrantLock();

    static {
        initialPool();
    }

    /**
     * @author zhangxiaoqiang
     * @date 2015下午10:23:15
     * @returnType Jedis
     * @description 得到连接
     */
    private static void initialPool() {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxActive(AppInitConstants.maxActive);
            config.setMaxIdle(AppInitConstants.maxIdle);
            config.setMaxWait(AppInitConstants.maxWaitSeconds);
            config.setTestOnBorrow(true);
            config.setMinIdle(8);//设置最小空闲数
            config.setTestOnReturn(true);
            //Idle时进行连接扫描
            config.setTestWhileIdle(true);
            //表示idle object evitor两次扫描之间要sleep的毫秒数
            config.setTimeBetweenEvictionRunsMillis(30000);
            //表示idle object evitor两次扫描之间要sleep的毫秒数
            config.setTimeBetweenEvictionRunsMillis(30000);
            //表示idle object evitor每次扫描的最多的对象数
            config.setNumTestsPerEvictionRun(10);
            //表示一个对象至少停留在idle状态的最短时间，然后才能被idle object evitor扫描并驱逐；这一项只有在timeBetweenEvictionRunsMillis大于0时才有意义
            config.setMinEvictableIdleTimeMillis(60000);
            pool = new JedisPool(config, AppInitConstants.host, AppInitConstants.port);
        } catch (Exception e) {
            log.error("First create JedisPool error : " + e);
        }
    }

    //获取 redis
    public static Jedis getJedis(){
        Jedis jedis = null;
        try {
            if (pool != null) {
                synchronized (pool) {
                    jedis = pool.getResource();
                }
            }
        } catch (Exception e) {
            log.error("Get jedis-136 error : " + e);
        }
        return jedis;
    }

    public  static void returnBrokenResource(Jedis redis) {
        try {
            if (redis != null) {
                pool.returnBrokenResource(redis);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @author zhangxiaoqiang
     * @date 2015下午10:23:31
     * @returnType void
     * @description 关闭连接
     */
    public static void returnResource(Jedis redis) {
        try {
            if (redis != null) {
                pool.returnResource(redis);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Created with IDEA .
     *
     * @author:zhangxiaoqiang .
     * @date:2016-01-05 13:53:29  .
     * @description:销毁pool
     */
    public static void reset() {
        try {
            pool.destroy();
            pool = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
