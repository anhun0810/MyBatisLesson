package cn.easytop.lesson05;

import redis.clients.jedis.Jedis;

public class JavaRedis {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost",6379);
		jedis.set("username","zhangsan");
		System.out.println(jedis.get("username"));
	}
}
