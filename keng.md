# 坑
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