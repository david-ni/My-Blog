# MySQL数据类型

- 数字类型
  - 整数: tinyint、smallint、mediumint、int、bigint
  - 浮点数: float、double、real、decimal
- 日期和时间: date、time、datetime、timestamp、year
- 字符串类型
  - 字符串: char、varchar
  - 文本: tinytext、text、mediumtext、longtext
- 二进制(可用来存储图片、音乐等): tinyblob、blob、mediumblob、longblob

## 数字类型

### 整型

| type      | Storage | Minumun Value        | Maximum Value        |
| :-------- | :------ | :------------------- | :------------------- |
|           | (Bytes) | (Signed/Unsigned)    | (Signed/Unsigned)    |
| TINYINT   | 1       | -128                 | 127                  |
|           |         | 0                    | 255                  |
| SMALLINT  | 2       | -32768               | 32767                |
|           |         | 0                    | 65535                |
| MEDIUMINT | 3       | -8388608             | 8388607              |
|           |         | 0                    | 16777215             |
| INT       | 4       | -2147483648          | 2147483647           |
|           |         | 0                    | 4294967295           |
| BIGINT    | 8       | -9223372036854775808 | 9223372036854775807  |
|           |         | 0                    | 18446744073709551615 |

### 浮点型

| 属性         | 存储空间 | 精度   | 精确性        | 说明                           |
| ------------ | -------- | ------ | ------------- | ------------------------------ |
| FLOAT(M, D)  | 4 bytes  | 单精度 | 非精确        | 单精度浮点型，m总个数，d小数位 |
| DOUBLE(M, D) | 8 bytes  | 双精度 | 比Float精度高 | 双精度浮点型，m总个数，d小数位 |
| DECIMAL(M,D) | M + 2    |        |               | 内部以字符串形式存储           |

- FLOAT容易造成精度丢失

#### 定点数DECIMAL

- 高精度的数据类型，常用来存储交易相关的数据
- DECIMAL(M,N).M代表总精度，N代表小数点右侧的位数（标度）
- 1 < M < 254, 0 < N < 60;
- 存储空间变长

## 时间类型

| 类型 | 字节 | 例 | 精确性 | 备注 |
| ---- | ----  | ---- | ---- | ---- |
| DATE | 三字节 | 2015-05-01 | 精确到年月日 |
| TIME | 三字节 | 11:12:00 | 精确到时分秒 |
| DATETIME | 八字节 | 2015-05-01 11::12:00 | 精确到年月日时分秒 | DATETIME(6)意思是保留6为毫秒数
| TIMESTAMP |  | 2015-05-01 11::12:00 | 精确到年月日时分秒 |  

- MySQL在`5.6.4`版本之后，`TIMESTAMP`和`DATETIME`支持到微秒。
- `TIMESTAMP`会根据系统时区进行转换，`DATETIME`则不会
- 存储范围的区别  
    - `TIMESTAMP`存储范围：1970-01-01 00::00:01 to 2038-01-19 03:14:07
    - `DATETIME`的存储范围：1000-01-01 00:00:00 to 9999-12-31 23:59:59
- 一般使用`TIMESTAMP`国际化
- 如存时间戳使用数字类型`BIGINT`

## 字符串类型

| 类型 | 存储(字节) | 特性 | 备注 |
| ---- | ----  | ---- | ---- |
| CHAR | 0-255 | 存储定长，容易造成空间的浪费 |
| VARCHAR(M) | 0-255 | 存储变长，节省存储空间 | M 表示所占字节数 | 
| TINYTEXT | 2^8-1 | - | 
| TEXT | 2^16-1 | - | 
| MIDIUMTEXT | 2^24-1 | - | 
| LONGTEXT | 2^32-1 | - |
| ENUM('value1','value2',...) | 集合最大数目为65535 |  
| SET('value1','value2') | 集合最大数目为64 |

- TEXT在MySQL内部大多存储格式为溢出页，效率不如CHAR
- Mysql默认为utf-8，那么在英文模式下1个字符=1个字节，在中文模式下1个字符=3个字节。

## 参考

- [MySQL数据类型](https://github.com/jaywcjlove/handbook/blob/master/MySQL/MySQL%E6%95%B0%E6%8D%AE%E7%B1%BB%E5%9E%8B.md)
- [MySQL Data Types](http://www.mysqltutorial.org/mysql-data-types.aspx)