package cn.how2j.springcloud.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cn.how2j.springcloud.pojo.Product;

//如果访问的 PRODUCT-DATA-SERVICE 不可用的话，就调用 ProductClientFeignHystrix 来进行反馈信息
@FeignClient(value = "PRODUCT-DATA-SERVICE",fallback = ProductClientFeignHystrix.class)
public interface ProductClientFeign {

    @GetMapping("/products")
    public List<Product> listProdcuts();
}