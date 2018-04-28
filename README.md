## 浅析实战swagger
> 接口管理的强大工具。

项目现在前后端分离，需要一个API的管理工具，在分析了如下几个最终选择了，swagger。比较主流的方式。

#### API管理
+ [swagger](https://swagger.io/)
+ [RAP](https://github.com/thx/RAP) 阿里出品，以开发为核心对接口维护
+ POSTMAN 
+ [DOClever](https://github.com/sx1989827/DOClever) 可视化接口管理工具，分析接口，校验接口，采用了JavaScript


#### 十分钟搭建以springboot为项目的API管理
> demo为第二种方式，也是官方推荐

##### 第一步
> 添加maven包
###### 第一种方式：
```
<!-- https://mvnrepository.com/artifact/com.mangofactory/swagger-springmvc -->
<dependency>
    <groupId>com.mangofactory</groupId>
    <artifactId>swagger-springmvc</artifactId>
    <version>1.0.2</version>
</dependency>

```
###### 第二种方式

```
 <dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.6.1</version>
</dependency>

<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.6.1</version>
</dependency>
```
> 官方建议是swagger2

#### 第二步骤

> 添加Configuration配置
```
package com.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swaggerSpringMvcPlugin(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("springboot利用swagger构建api文档")
                .description("简单优雅的restfun风格")
                .version("1.0")
                .build();

    }

}
```
#### 第三步

启动springboot项目，访问:localhost:

```
http://localhost:9999/swagger-ui.html
```

![swagger](http://og3rfccos.bkt.clouddn.com/swagger.png)
