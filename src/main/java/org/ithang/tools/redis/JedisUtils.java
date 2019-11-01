package org.ithang.tools.redis;

import org.ithang.tools.lang.SpringContextHolder;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisUtils {

   private static JedisPool jedisPool = SpringContextHolder.getBean("jedisPool");
   
   
   public static boolean exist(String key){
	   Jedis jedis = jedisPool.getResource();
	   boolean saved=jedis.exists(key);
	   jedis.close();
	   return saved;
	   
   }
   
   /**
    * 
    * @param key
    * @param value
    * @param timeout 单位秒
    */
   public static void set(String key, String value,long timeout) {
       Jedis jedis = jedisPool.getResource();
       if(jedis.exists(key)){
       	jedis.del(key);
       }
       jedis.set(key, value, "NX", "EX", timeout);
       jedis.close();
   }
   
   
    public static void set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        if(jedis.exists(key)){
        	jedis.del(key);
        }
        jedis.set(key, value);
        jedis.close();
    }
    
    public static String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String r= jedis.get(key);
        jedis.close();
        return r;
    }
	
}
