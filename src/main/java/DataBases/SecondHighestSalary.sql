+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+

#如果没有合适值得话 返回的是null
Select (Select  CustomerId from orders order by CustomerId DESC limit 1,1) as Second;
#limit 1 offset 1 代表的是第二个

#外面再嵌套一层Select 才会出现null这种情况

Select (Select  CustomerId from orders order by CustomerId DESC limit 1,1) as Second;
200

limit 的用法
Select  CustomerId from orders order by CustomerId DESC limit 2,2
从第2条开始读 读2条信息 如果没那么多就读1条

Select  CustomerId from orders order by CustomerId DESC limit 2 offset 1

select * from table LIMIT 5,10; #返回第6-15行数据
select * from table LIMIT 5; #返回前5行
select * from table LIMIT 0,5; #返回前5行