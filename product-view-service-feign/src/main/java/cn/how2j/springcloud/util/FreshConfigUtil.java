package cn.how2j.springcloud.util;

import java.util.HashMap;

import cn.hutool.http.HttpUtil;

public class FreshConfigUtil {

    public static void main(String[] args) {
        HashMap<String,String> headers =new HashMap<>();
        headers.put("Content-Type", "application/json; charset=utf-8");
        System.out.println("因为要去git获取，还要刷新config-server, 会比较卡，所以一般会要好几秒才能完成，请耐心等待");

        //这个地址的作用就是让 config-server 去 git 获取最新的配置信息，
        // 并把此信息广播给集群里的两个 视图微服务。
        String result = HttpUtil.createPost("http://localhost:8012/actuator/bus-refresh").addHeaders(headers).execute().body();
        System.out.println("result:"+result);
        System.out.println("refresh 完成");
    }
}