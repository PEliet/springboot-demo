**一。application.yml的几种后缀**

1-dev:测试环境使用，在原文件里使用以下代码，在active后面选择后缀即可。

```
spring:
  profiles:
    active: 
```

2-prod:上线时使用，在active后用prod即可。



**二.springboot的三层架构**

1. 分为controller,service,mapper（持久层）层，每层里创建的东西用对应层的名字做后缀


2.controller层用于接收用户的post,put,get,delete等请求，调用service层的代码，service调用mapper中的方法，mapper再返回给service，service返回给controller，controller返回给前端

3.持久层框架便是mybatis



**三.引入lombok就可以不用写getter,setter方法**



**四.几种向容器中注入对象的方法**

1.使用 Java 配置类（@Configuration + @Bean）

```java
@Configuration
public class AppConfig {
    
    @Bean
    public UserService userService() {
        return new UserService();
    }
}
```

2.使用注解（自动扫描），在类上添加 Spring 提供的注解，容器会自动扫描并注册为 Bean。

```java
@Component
public class UserService {
    public void doSomething() {
        System.out.println("UserService 执行");
    }
}

// @Service - 业务逻辑层
@Service
public class OrderService {
    public void createOrder() {
        System.out.println("创建订单");
    }
}

// @Repository - 数据访问层
@Repository
public class UserRepository {
    public User findById(Long id) {
        return new User();
    }
}

// @Controller / @RestController - 控制层
@RestController
public class UserController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
```

3.XML 配置文件

`applicationContext.xml`

4.@Resource和@Autowired

| 特性              | @Resource                        | @Autowired                                |
| :---------------- | :------------------------------- | :---------------------------------------- |
| **来源**          | Java 标准（JSR-250）             | Spring 框架                               |
| **默认注入方式**  | 按名称（byName）                 | 按类型（byType）                          |
| **匹配规则**      | 1. 按名称 2. 按类型 3. 报错      | 1. 按类型 2. 按名称（@Qualifier） 3. 报错 |
| **required 属性** | 默认 true，可设置 required=false | 默认 true，可设置 required=false          |
| **配合其他注解**  | 配合 @Qualifier 使用             | 配合 @Qualifier、@Primary 使用            |

注：**`@Bean` 是 Spring 框架提供的注解，用于在配置类中显式声明一个 Bean**，告诉 Spring 容器该方法返回的对象需要被管理。**



五.数据库添加字段

```java
    @TableField("create_time")//解决数据库字段与开发名称不一致的情况
    private LocalDateTime createTime;
    @TableField("update_time")//内部值表示这个属性映射数据库的哪个字段
    private LocalDateTime updateTime;
}
```

```java
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//改时间格式的

private LocalDateTime createTime;
@TableField(value="update_time" , fill= FieldFill.UPDATE)//内部值表示这个属性映射数据库的哪个字段
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")

private LocalDateTime updateTime;
```

@JsonFormat修改输出内容的格式