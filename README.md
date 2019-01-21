# apidocCandy
说明：java根据注解生成api

支持：参数/返回值中 有循环引用的暂不支持

     暂时只支持 mysql持久化

     公用参数或返回值，请根据不同需求分次处理   

     开发ing ...   
bug：重复执行时 参数，返回值不能自动删除   

使用手册：   
1.下载源码
  mvn install 安装到本地仓库
  
2.增加maven依赖
```
        <dependency>
            <groupId>org.happybeen.apicandy</groupId>
            <artifactId>apicandy-core</artifactId>
            <version>1.0</version>
        </dependency>
```
```
        <plugin>
             <groupId>org.happybeen.apicandy</groupId>
             <artifactId>apicandy-maven-plugin</artifactId>
             <version>1.0</version>
        </plugin>
```
3.注解配置参考：   
  apidoc-demo 模块   
  
4.配置文件 (resources目录下）
 4.1 candyconf.xml
```
<?xml version="1.0" encoding="UTF-8" ?>

<candyConfiguration>

    <javaSource package="org.happybeen.apicandy.demo"/>

    <!-- 引入配置文件 -->
    <properties resource="candy.properties"/>

    <!--jdbc配置-->
    <jdbcConnection>
        <driverClass>${jdbcDriver}</driverClass>
        <classPath>${classPath}</classPath>
        <connectionURL>${jdbcUrl}</connectionURL>
        <userId>${jdbcUser}</userId>
        <password>${jdbcPassword}</password>
    </jdbcConnection>

    <!-- tableName 数据库表名 value表属性名 -->
    <tables>
        <table tableName="apicandy_action" property="action"> 
            <column value="id" property="id"/>
            <column value="name" property="name"/>
            <column value="path" property="path"/>
            <column value="method" property="method"/>
            <column value="desc" property="desc"/>
        </table>
        <table tableName="apicandy_param" property="param">
            <column value="id" property="id"/>
            <column value="action_id" property="actionId"/>
            <column value="name" property="name"/>
            <column value="type" property="type"/>
            <column value="required" property="required"/>
            <column value="desc" property="desc"/>
            <column value="last_id" property="lastId"/>
        </table>
        <table tableName="apicandy_header" property="header">
            <column value="id" property="id"/>
            <column value="action_id" property="actionId"/>
            <column value="name" property="name"/>
            <column value="required" property="required"/>
            <column value="desc" property="desc"/>
        </table>
        <table tableName="apicandy_result" property="result">
            <column value="id" property="id"/>
            <column value="action_id" property="actionId"/>
            <column value="name" property="name"/>
            <column value="value" property="value"/>
            <column value="type" property="type"/>
            <column value="desc" property="desc"/>
            <column value="last_id" property="lastId"/>
        </table>
    </tables>
    
    <!-- java 对应显示的 api数据类型 -->
    <javaTypeResolver>
        <property javaType="int" apiType="number"/>
        <property javaType="long" apiType="number"/>
        <property javaType="double" apiType="number"/>
    </javaTypeResolver>

</candyConfiguration>


```

 4.2 candy.properties
```
#classPath 写绝对路径
classPath=/opt/mysql-connector-java-5.1.47.jar
jdbcDriver=com.mysql.jdbc.Driver
jdbcUrl=jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false
jdbcUser=root
jdbcPassword=123456

```
5.配置表sql   
 略   
6. 编译项目      
7.使用apicandy插件生成api文档   
  7.1 idea 插件执行    
      略   
  7.2 执行apicandy命令   
      mvn apicandy:generator   
