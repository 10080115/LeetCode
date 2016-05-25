+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+



+---------+
| Email   |
+---------+
| a@b.com |
+---------+

//找出有重复的邮件

SELECT Email
FROM Person
GROUP BY Email HAVING count(*) > 1;

//找出重复的邮件

SELECT DISTINCT a.Email
FROM Person a JOIN Person b
ON (a.Email = b.Email)
WHERE a.Id <> b.Id