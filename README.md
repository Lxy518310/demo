##SpringBoot+Git+GitHub项目

##资料
[Spring 文档](https://spring.io/guides)
[GitHub获取个人信息](https://api.github.com/users/codedrinker)
[GitHub获取用户信息](https://api.github.com/users?access_tokend=64b9f675361985a2e3a624be37ab7dcaa9d77e9)

##网址
[OkHttp](https://square.github.io/okhttp/)
#    导入OkHttp包
    <dependency>(https://api.github.com/users?access_tokend=64b9f675361985a2e3a624be37ab7dcaa9d77e9)
        <groupId>com.squareup.okhttp3</groupId>
        <artifactId>okhttp</artifactId>
        <version>3.14.1</version>
    </dependency>
    
[fastjson](https://github.com/topics/fastjson)
#    导入FastJSON
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>fastjson</artifactId>
        <version>1.2.57</version>
    </dependency>
  
[lombok](https://projectlombok.org/)
#    导入lombok  自动生成setter/getter方法
	<dependency>
		<groupId>org.projectlombok</groupId>
		<artifactId>lombok</artifactId>
		<version>1.18.10</version>
		<scope>provided</scope>
	</dependency>

[flyway](https://flywaydb.org/)
#添加Flyway数据库版本管理工具
    <plugin>
        <groupId>org.flywaydb</groupId>
        <artifactId>flyway-maven-plugin</artifactId>
        <version>6.0.4</version>
        <configuration>
            <url>jdbc:mysql://localhost:3306/demo?characterEncoding=utf8&amp;useUnicode=true&amp;useSSL=false&amp;serverTimezone=UTC</url>
            <user>root</user>
            <password>123456</password>
        </configuration>
    </plugin>
    
[MyBatis Generator](http://mybatis.org/generator/)
#用于自动生成mapper的工具
#使用generatorConfig.xml
#使用org.mybatis.generator.plugins.RowBoundsPlugin 插件完成MyBatis分页功能