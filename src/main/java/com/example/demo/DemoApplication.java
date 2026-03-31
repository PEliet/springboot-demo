package com.example.demo;

import jakarta.annotation.Resource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/index")//给链接增加访问路径的@requestmapping注解，但是@Getmapping里面也存在这个，所以用后面这个新的就可以
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@RequestMapping("/hello")
//	 public String hello(){
//		return "Hello World";
//	 }

//	@GetMapping
//	public String index() {
//		return "GET无参请求api方法已经实现";
//	}


	//以下为spring MVC的常见用法，增删改查啥的
	@GetMapping("/{id}")
	public String index(@PathVariable Long id) {
		System.out.println(id);//可注可不注，不影响网页打开
		return "GET Restful请求传值的方法实现成功";
	}

	@GetMapping
	public String index2(@RequestParam Long id, @RequestParam String name) {
		System.out.printf("ID=%s, name=%s\n", id, name);
		return "Get普通请求传值 方法已经实现了";
	}


	@PostMapping
	public String save(@RequestBody Map<String, String> map) {
		System.out.println(map.toString() );
		return "post请求成功";
	}

	@PutMapping("/{id}")
	public String update(@PathVariable Long id,@RequestBody Map<String, String> map) {
		System.out.printf("ID=%s,name=%s\n",id,map);
		return "put请求接收成功";
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		System.out.printf("ID=%s\n", id);
		return "delete请求接收成功";
	}
}