package com.hskj.common;
import redis.clients.jedis.Jedis;
public class Jides {
	 public static void main(String[] args) {
	        //连接本地的 Redis 服务
	        Jedis jedis = new Jedis("192.168.1.11",6379);
	        System.out.println("连接成功");
	        //查看服务是否运行
	        System.out.println("服务正在运行: "+jedis.ping());
	        jedis.set("runoobkey", "www.runoob.com");
	        // 获取存储的数据并输出
	        System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));
	    }
}
