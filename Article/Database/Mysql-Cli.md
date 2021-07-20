# Mysql 常用命令行

```bash
# 查看帮助 
help;

# 查看版本 
mysql --version;

# 登录
mysql -uuserName -p[password] -D database;

# 显示服务器支持的引擎
show engines;

# 显示数据库列表
show databases;

# 显示当前已打开的数据库
select database();

# 切换数据库
use databasename;

# 显示当前数据库的表
show tables;

# 显示tablename这个表的详细信息 
describe tablename;
```