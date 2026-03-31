package com.example.demo;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("com.example.demo.mapper")
class DemoApplicationTests {

	@Autowired//自动注入，用这个注解后就可以使用下面接口的所有方法了。@Resource也可以用在这里
	public UserMapper userMapper;
	@Resource
	private UserService userService;
	@Test
	void contextLoads() {
		System.out.println(("----- selectAll method test ------"));
		List<User> userList = userMapper.selectList(null);
		Assert.isTrue(5 == userList.size(), "");
		userList.forEach(System.out::println);
	}
	@Test
	void contextService() {
		List<User> userList=userService.list();
		userList.forEach(System.out::println);
	}
}
