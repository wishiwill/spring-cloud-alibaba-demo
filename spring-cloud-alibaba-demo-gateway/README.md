# 网关模块
## 集成swagger3.0
[重新认识Swagger和Springfox](https://www.cnblogs.com/jason1990/archive/2020/03/27/12581773.html#:~:text=Springfox%E5%85%B6%E5%AE%9E%E6%98%AF%E4%B8%80%E4%B8%AA%20%E9%80%9A%E8%BF%87%E6%89%AB%E6%8F%8F%E4%BB%A3%E7%A0%81%E6%8F%90%E5%8F%96%E4%BB%A3%E7%A0%81%E4%B8%AD%E7%9A%84%E4%BF%A1%E6%81%AF%EF%BC%8C%E7%94%9F%E6%88%90API%E6%96%87%E6%A1%A3%E7%9A%84%E5%B7%A5%E5%85%B7%20%E3%80%82%20API%E6%96%87%E6%A1%A3%E7%9A%84%E6%A0%BC%E5%BC%8F%E4%B8%8D%E6%AD%A2Swagger%E7%9A%84%20OpenAPI%20Specification,%EF%BC%8C%E8%BF%98%E6%9C%89%20RAML%20%EF%BC%8C%20jsonapi%20%EF%BC%8CSpringfox%E7%9A%84%E7%9B%AE%E6%A0%87%E5%90%8C%E6%A0%B7%E5%8C%85%E6%8B%AC%E6%94%AF%E6%8C%81%E8%BF%99%E4%BA%9B%E6%A0%BC%E5%BC%8F%E3%80%82%20%E8%BF%99%E5%B0%B1%E8%83%BD%E8%A7%A3%E9%87%8A%E9%82%A3%E4%B8%AAswagger2%E7%9A%84%E5%90%8E%E7%BC%80%E4%BA%86%EF%BC%8C%E8%BF%99%E5%8F%AA%E6%98%AFSpringfox%E5%AF%B9Swagger%E7%9A%84%E6%94%AF%E6%8C%81%E3%80%82)
### swagger3.0注解
@Api：用在控制器类上，表示对类的说明
tags="说明该类的作用，可以在UI界面上看到的说明信息的一个好用注解"
value="该参数没什么意义，在UI界面上也看到，所以不需要配置"

@ApiOperation：用在请求的方法上，说明方法的用途、作用
value="说明方法的用途、作用"
notes="方法的备注说明"

@ApiImplicitParams：用在请求的方法上，表示一组参数说明
@ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面（标注一个指定的参数，详细概括参数的各个方面，例如：参数名是什么？参数意义，是否必填等）
name：属性值为方法参数名
value：参数意义的汉字说明、解释
required：参数是否必须传
paramType：参数放在哪个地方
· header --> 请求参数的获取：@RequestHeader
· query --> 请求参数的获取：@RequestParam
· path（用于restful接口）--> 请求参数的获取：@PathVariable
· div（不常用）
· form（不常用）    
dataType：参数类型，默认String，其它值dataType="Integer"       
defaultValue：参数的默认值

@ApiResponses：用在请求的方法上，表示一组响应
@ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
code：状态码数字，例如400
message：信息，例如"请求参数没填好"
response：抛出异常的类

@ApiModel：用于响应类上（POJO实体类），描述一个返回响应数据的信息（描述POJO类请求或响应的实体说明）
（这种一般用在post接口的时候，使用@RequestBody接收JSON格式的数据的场景，请求参数无法使用@ApiImplicitParam注解进行描述的时候）
@ApiModelProperty：用在POJO属性上，描述响应类的属性说明
@ApiIgnore：使用该注解忽略这个API；
## 集成swagger-ui knife4j
[spring-cloud微服务架构引入knife4j](https://gitee.com/xiaoym/knife4j#spring-cloud%E5%BE%AE%E6%9C%8D%E5%8A%A1%E6%9E%B6%E6%9E%84)
在Spring Cloud的微服务架构下,每个微服务其实并不需要引入前端的Ui资源,因此在每个微服务的Spring Boot项目下,引入knife4j提供的微服务starter
```xml
<dependency>
    <groupId>com.github.xiaoymin</groupId>
    <artifactId>knife4j-micro-spring-boot-starter</artifactId>
    <version>${knife4j.version}</version>
</dependency>
```
在网关聚合文档服务下,可以再把前端的ui资源引入
```xml
<dependency>
    <groupId>com.github.xiaoymin</groupId>
    <artifactId>knife4j-spring-boot-starter</artifactId>
    <version>${knife4j.version}</version>
</dependency>
```

## 报错503
[springcloud2020.0.0 版本+gateway+nacos，服务报错503 Service Unavailable](https://blog.csdn.net/xinzuini/article/details/118389193)
```xml
<!--负载均衡loadbalancer-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-loadbalancer</artifactId>
</dependency>
```
原因：
由于springcloud2020弃用了Ribbon，因此Alibaba在2021版本nacos中删除了Ribbon的jar包，因此无法通过lb路由到指定微服务，出现了503情况。
所以只需要引入springcloud loadbalancer包即可
