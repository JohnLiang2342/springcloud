package cn.how2j.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

import cn.hutool.core.util.NetUtil;


//作用是把一个集群里的多个实例汇聚在一个 turbine里，
// 这个然后再在 断路器监控里查看这个 turbine, 这样就能够在集群层面进行监控
@SpringBootApplication
@EnableTurbine
public class ProductServiceTurbineApplication {
    public static void main(String[] args) {
        int port = 8021;
        if(!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }
        new SpringApplicationBuilder(ProductServiceTurbineApplication.class).properties("server.port=" + port).run(args);

    }

}