# Spring Boot

## Reference

- [Spring Boot Release Notes](https://github.com/spring-projects/spring-boot/wiki#release-notes)
- [Spring Boot 官方文档](https://docs.spring.io/spring-boot/docs/2.4.1/reference/htmlsingle/)
- [SpringBoot2零基础入门](https://www.bilibili.com/video/BV19K4y1L7MT)

## Spring Boot 简介

Spring Boot 是整合Spring技术栈的一站式脚手架，能够快创建出生产级别的Spring应用，省去繁琐的配置。

### 优点：

1. 能够创建独立的Spring应用
2. 内嵌`Tomcat`、`Jetty`以及`Undertow` web服务器
3. 提供多种"starter"，简化构建配置
4. 自动配置Spring以及第三方功能
5. 提供生产级别的监控、健康检查及外部化配置
6. 无代码生成、无需编写XM

### 系统要求

目前最新版本的Spring Boot（2.4.0）要求至少是Java8+（最高兼容到Java15），Maven 3.3+或者Gradle 6+

### Starters（场景启动器）

Spring boot声明了多个不同场景的starter，比如开发web应用直接引入`spring-boot-starter-web`

> [官方starter](https://docs.spring.io/spring-boot/docs/2.4.1/reference/htmlsingle/#using-boot-starter)

- `spring-boot-starter-parent`: 声明了开发中常用依赖的版本号、Maven插件等

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.4.1</version>
</parent>
```

## Spring Boot Web

### 静态资源

默认情况下，只要把静态资源放在类路径下的以下几个目录：
`/static` (or `/public` or `/resources` or `/META-INF/resources`

通过访问 `http://xxxxx/静态资源名称`

```properties
## 修改静态资源访问路径前缀
spring.mvc.static-path-pattern = /resources/**

## 修改静态资源存放的根路径
spring.web.resources.static-locations = /
```

### 最佳实践

#### 1. 使用Lombok 

> [Lombok官方](https://projectlombok.org/features/all)

#### 2. Spring DevTool

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <optional>true</optional>
</dependency>
```

> 快捷键 mac: `command+fn+F9`

- 默认配置

在开发环境，spring-boot-devtools会注入一些默认的配置，具体看移步[DevToolsPropertyDefaultsPostProcessor.java](https://github.com/spring-projects/spring-boot/blob/v2.4.1/spring-boot-project/spring-boot-devtools/src/main/java/org/springframework/boot/devtools/env/DevToolsPropertyDefaultsPostProcessor.java)

- 自动重启

> https://docs.spring.io/spring-boot/docs/2.4.1/reference/htmlsingle/#using-boot-devtools-restart

如果`classpath`中的文件发生变化，应用自动重启

- LiveReload

当资源变化时，浏览器自动刷新

> To trigger LiveReload when a file changes, Automatic Restart must be enabled.

- Global Settings
- Remote Applications

#### 3. 自定义类绑定的配置提示

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>
```

## 附录-Spring 常用注解

- **@SpringBootApplication**

`@SpringBootApplication`用于入口应用类，相当于使用`@EnableAutoConfiguration`、`@ComponentScan`以及`@Configuration`这三个注解。


```java
package com.example.myapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// same as @Configuration @EnableAutoConfiguration @ComponentScan
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
```

- **@EnableAutoConfiguration**

是否自动加载Spring所需的配置

> [Spring自动装配原理](https://www.bilibili.com/video/BV19K4y1L7MT?p=14)

- **@Configuration**

指示一个类声明一个或多个`Bean`方法，并注册到Spring 容器中

```java
@Configuration
public class MyConfiguration {
    @Bean
    public MyBean myBean() {
		return new MyBean();
	}
}
```

- **@ComponentScan**

指定要扫描的包，所有被`@Component`、`@Service`、`@Repository`、`@Controller`等注解的类都将自动注册到Spring容器中

```java
@SpringBootConfiguration
@ComponentScan(basePackages = "st.java.springboot")
@EnableAutoConfiguration
public class Application{
    public static void main(String[] args){
       ConfigurableApplicationContext context = SpringApplication.run(Application.class,args);
    }
}
```

- **@Import**

添加指定的类到spring容器中

```java
@Configuration
@Import({ExampleBean.class})
public class AppConfig{
    // ....
}
```
不同于`@ComponentScan`，`@Import`可以指定一个或多个类，这有助于将第三方依赖（非springs实现）添加到容器中。

- **@Conditional 条件装配**
- @ImportResource 导入配置文件
- @ConfigurationProperties
- @EnableConfigurationProperties