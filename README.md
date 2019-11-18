# MyBatis
#  一、参数类型
# 输入参数：ParameterType
+ 类型为 简单类型(8个基本类型+String)

1、 #{}、${}区别

a、 简单类型表达式为#{}时，#{任意值}	
     简单类型表达式为${}时，${value} 其中标识符只能是value
     
b、 #{}会自动给String加上 ' '  (自动类型转换)
	select * from book_1 where bookId = #{bookId} 

     ${} 原样输出 但是适合于 动态排序 （动态字段）	
	需要传值时 需加 ‘ ’( ' ${value} ' )
	select * from book_1 where bookId = ' ${value} '

动态排序:

 select bookId, bookName, boookPrice from book_1 order by bookName desc
order by bookName desc 静态排序

	order by 排序字段 desc 
  
select bookId, bookName, bookPrice from book_1 order by ${value} asc


c、#{}：可以防止SQL注入

     ${}：不防止

 1.1、#{}、${}相同之处
 
a、多可以获取对象的值(嵌套类型对象)

  i: 获取对象值
  
模糊查询，方式一：

 select bookId, bookName, bookPrice from book_1 
 
        where bookPrice = #{bookPrice} or bookName like '%${bookName}%'
        
模糊查询，方式二：

 select bookId, bookName, bookPrice from book_1 
 
        where bookPrice = #{bookPrice} or bookName like #{bookName}
        
	book.setBookName("语");
	
 ii:嵌套类型对象
 
 + 对象类型
 
#{属性名}

${属性名}

# 二、类型转换器

+ 类型处理器(类型转换器)

1.MyBatis自带一些常见的类型处理器

	int - number
  
2.自定义MyBatis类型处理器
	
	java - 数据库(JDBC类型)
  
示列：

实体类Book: boolean   bookSell（是否出售）

			true：出售
      
			false：不出售	

 表Book：     number     bookSell
 
			0:出售
      
			1：不出售	

+ 自定义类型转换器(boolean ——number)步骤：

a.创建转换器

 1.实现接口TypeHandler
 
  2.继承BaseTypeHandler

+ resultMap可以实现2功能

1、  类型转换

2、属性和字段的映射关系

# 三、MyBatis配置文件
 + MyBatis框架的xml配置包含两种类型：
 
 * 1) SqlMapConfig.xml (1个)
 
	 — 主配置文件， 用于指定数据库连接参数和框架参数
	 
 * 2) SqlMap.xml (n个)
 
 	— 映射定义文件， 用于定义 sql 语句和映射信息 

# 四、框架API简介

  在使用MyBatis框架时 主要涉及以下几个API
  
  * SqlSessionFactoryBuilder 
     - 该对象负责根据MyBatis配置文件 SqlMapConfig.xml 构建 SqlSessionFactory实列
	
	
 
