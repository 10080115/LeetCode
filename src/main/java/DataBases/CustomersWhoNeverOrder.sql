//Customers
+----+-------+
| Id | Name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+

//Orders
+----+------------+
| Id | CustomerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+

+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+

Select Name not IN (Select Name from Customers left jon Orders on Customers.Id = Orders.CustomerId)