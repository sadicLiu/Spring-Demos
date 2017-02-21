# Spring JDBCTemplate learning notes

## 环境搭建

1. 创建表

  ```
  create database jdbc_template;
  use jdbc_template;
  create table t_user(
  id int primary key auto_increment,
  username varchar(20),
  password varchar(20)
  );

  insert into t_user(username, password) values('zhangsan', '123');
  ```

2. 引入jar包

  ```
  <!-- MySQL驱动-->
  <dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <version>${mysql-jdbc.version}</version>
  </dependency>
  <!-- Spring JDBC开发-->
  <dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-jdbc</artifactId>
  <version>${spring.version}</version>
  </dependency>
  <dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-tx</artifactId>
  <version>${spring.version}</version>
  </dependency>
  <!-- 数据库连接池-->
  <dependency>
  <groupId>commons-dbcp</groupId>
  <artifactId>commons-dbcp</artifactId>
  <version>${dbcp.version}</version>
  </dependency>
  ```

## DBCP实现

> 1000_JDBCTemplate_DBCP

- Dao类

  ```
  public class UserDao {

      private JdbcTemplate jdbcTemplate;

      public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
          this.jdbcTemplate = jdbcTemplate;
      }

      public boolean update(User user) {
          String sql = "update t_user set username=?, password=? where id=?";
          Object[] args = {user.getUsername(), user.getPassword(), user.getId()};
          jdbcTemplate.update(sql, args);

          return true;
      }

  }
  ```

- Spring配置

  ```
  <!-- 创建数据源-->
  <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
      <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
      <property name="url" value="jdbc:mysql://localhost:3306/jdbc_template"/>
      <property name="username" value="root"/>
      <property name="password" value="1111"/>
  </bean>

  <!-- 创建模板，注入数据源-->
  <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
      <property name="dataSource" ref="dataSource"/>
  </bean>

  <bean id="userDao" class="com.liuhy.dbcp.UserDao">
      <property name="jdbcTemplate" ref="jdbcTemplate"/>
  </bean>
  ```

## C3P0实现

> 1100_JDBCTemplate_C3P0

- Spring配置

  ```
  <!-- 创建数据源-->
  <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
      <property name="driverClass" value="com.mysql.jdbc.Driver"/>
      <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/jdbc_template"/>
      <property name="user" value="root"/>
      <property name="password" value="1111"/>
  </bean>

  <!-- 创建模板，注入数据源-->
  <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
      <property name="dataSource" ref="dataSource"/>
  </bean>

  <bean id="userDao" class="com.liuhy.c3p0.UserDao">
      <property name="jdbcTemplate" ref="jdbcTemplate"/>
  </bean>
  ```
