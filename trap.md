# 坑
## 复制函数
### 对于所有的复制操作，都需要在返回结果前【删除UUID】，以防止模板项目被恶意篡改！！！！



## SpringSecurity
如何理解安全控制模块的引入方式：
http://www.macrozheng.com/#/technology/springsecurity_use

## Mybatis-generator
1. 需要加上 `<plugin type="org.mybatis.generator.plugins.UnmergeableXmlMappersPlugin" />`才能让生成的xml文件覆盖原始文件，否则会叠加上去导致运行时错误
2. 需要在子module的`pom.xml`中引入如下配置才能让`xxxMapper.xml`索引有效：
```xml
<build>
    <resources>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>false</filtering>
        </resource>
        <resource>
            <directory>src/main/resources</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>false</filtering>
        </resource>
    </resources>
</build>
```
3. MySQL8对应的driver类是`jdbc.driverClass=com.mysql.cj.jdbc.Driver`，中间有`cj`
4. 需要在generatorConfig.xml中指定好正确的数据库表名才能不报错

---

## 全局异常处理及跨域问题
### 全局异常处理设置方法
```java
@RestControllerAdvice
@Slf4j
public class GlobalExcepitonHandler {
    /**
     * 处理Assert的异常
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseVO handler(IllegalArgumentException e) throws IOException {
        log.error("Assert异常:-------------->{}", e.getMessage());
        return ResponseVO.failed(e.getMessage());
    }
}
```
这里使用到全局设置RestControllerAdvice，搭配ExceptionHandler，就可以进行全局controller扫描+异常处理。
###【前提】
对于有多个module的项目，比如本项目，在一个父工程liuxuesheng下，我们有多个模块，比如liuxuesheng/admin, liuxuesheng/common。
我们把通用代码写在common模块中，比如这里的全局异常处理类；而把其他的业务代码写在别的模块。
这就需要我们：
1. 在其他的业务模块pom文件中增加对common的依赖：
```xml
<!--liuxuesheng/admin/pom.xml-->
<dependency>
    <groupId>scut.yulin</groupId>
    <artifactId>common</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```
2. 在其他的业务模块启动类中增加对common模块的包扫描：
```java
//在admin模块中
package scut.yulin.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"scut.yulin.common","scut.yulin.admin"})
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
```
同时需要注意的是，我们在其他业务模块中一定要把自己这个包也扫描到，而且范围要足够大，否则就会出现自己模块下controller的404情况或者service无法注入的情况。
### 反例：
```java
//admin模块的启动类：
@SpringBootApplication(scanBasePackages = {"scut.yulin.common"})    //自己的模块不扫描就会controller404
@SpringBootApplication(scanBasePackages = {"scut.yulin.common","scut.yulin.admin.controller"})  //自己的模块扫描范围不够大就会service等注入失败

//------------------------
//common模块的启动类：
@SpringBootApplication(scanBasePackages = {"scut.yulin.admin"})     //根本就扫描不到，因为pom中没有依赖，也不能引入依赖，否则会造成循环依赖错误
```

### 全局异常处理注意点
1. 不要定义包含重复Exception的handler



# 预期优化点
1. 使用观察者模式，多线程优化schedule子类的加载：主要因为其中有多个于外表的关联需要加载
2. 返回最少必须的数据，优化传输效率，比如vehicle中的transportationType就可以只回传一个字符串，而不是一个DTO类

# service功能分类
需要提供审核的接口：
1. image
2. comment

不提供修改接口：
1. image
2. comment

# 不同类型的坑
1. 需要在xxxDao类上配置@Mapper

2. controller方法中，一般都需要使用DTO进行传输数据进行CRUD，需要加上@RequestBody才可以顺利传输这个DTO

3. modify时如果需要把deleted考虑上，所以需要新增一个类内函数用于查找所有行，包括已被逻辑删除的那些

4. 接口幂等性保持问题需要解决：比如对于tranportation的新增，就可能会导致多个相同项

5. MyBatis报错 Cannot determine value type from string 'xxxxxx'：有两种情况会导致这个问题
：（1）数据库字段和实体类的属性不匹配 （2）重写了实体类的有参构造后，没有写无参构造,补上无参构造即可 
。这里的情况属于后者，所以只需要在类开头补上@NoArgsConstructor
   
6. 所有的getByUuid/modify/delete方法都需要判断uuid是否为空，如果为空则直接返回null或者返回2，表示目标项找不到