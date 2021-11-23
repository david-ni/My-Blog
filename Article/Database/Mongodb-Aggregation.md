# MongoDb 聚合

使用聚合操作符可以对集合中的文档进行变换和组合。

- [管道操作符](#pipe)
    - [匹配操作符(`$match`)](#match)
    - [投射操作符(`$project`)](#project)
    - [拆分操作符(`$unwind`)](#unwind)
    - [分组操作符(`$group`)](#group)
- [聚合操作符](#operation)
    - [数学操作符](#operation-math)
    - [逻辑操作符](#operation-logic)
    - [比较操作符](#operation-compare)
    - [字符串操作符](#operation-string)
    - [日期操作符](#operation-date)
    - [条件操作符](#operation-condition)
    - [分组操作符](#operation-group)

## 管道操作符

每个操作符都会接收一连串的文档，对这些文档做一些类型转换后会将结果传递给下一个操作符。

不同的管道操作符可以按任意顺序组合在一起使用，而且可以被重复任意多次。比如：

```js
db.demo.aggragate(["$match": { id: 1 },"$project": { name: 1 }])
```

上例对`demo`这个文档使用了`$match`和`$project`这两个操作符。

### 匹配操作符(`$match`) 

[`$match`](https://mongoing.com/docs/reference/operator/aggregation/match.html) 用于对文档进行筛选，语法：

```js
{ $match: { <query> } }
```

对于`<query>`的使用可以查看[这里](https://mongoing.com/docs/tutorial/query-documents.html#read-operations-query-argument)。

在实际使用中，应该尽可能的将`$match`放在前面的位置，这样做有两方面的考虑：

1. 可以快速的过滤不需要的文档
2. 如果在投射和分组前使用`$match`，查询可以使用索引

### 投射操作符(`$project`)

[`$project`](https://mongoing.com/docs/reference/operator/aggregation/project.html)可以抽取文档中的指定字段。语法：

```js
{ $project: { <expression> } }
```

比如`demo`这个Collection中有如下文档结构：

```js
{ id: 10,name: "demo",metadata: { version: "1.0.0",desc: "demo" } }
```

现在使用`$project`抽取指定字段：

```js
db.demo.aggregate([{$project: { id: 1,"metadata.version": 1 }}])
```

执行之后的结果会移除`name`和`desc`字段

```js
{ _id: ObjectId("5e9dac135837df6b8afe5b3c"),id: 10, metadata: { version: "1.0.0" } }
```

#### 包含和排除字段

Mongo中使用`0`和`1`来表示字段的去留：

```js
db.demo.aggregate([{$project: { id: 1,"metadata.version": 1 }}])
```

也可以使用下面的形式：

```js
db.demo.aggregate([{$project: { id: 1,metadata: { version: 1 }}}])
```

#### 定义别名

在某些业务场景下，我们希望自定义字段的名称或者提取嵌套内的字段：

```js
db.demo.aggregate([{$project: { cusId: "$id","version": "$metadata.version" }}])
```

#### 其他操作

可以使用[聚合操作符]()定义更复杂的表达式。

### 拆分操作符(`$unwind`)

[`$unwind`](https://mongoing.com/docs/reference/operator/aggregation/unwind.html)可以将数组中的每一个值拆分成单独的文档。语法：

```js
{ $unwind: <field path> }
```

3.2版本后的语法：

```js
{
  $unwind:
    {
      path: <field path>,
      includeArrayIndex: <string>,
      preserveNullAndEmptyArrays: <boolean>
    }
}
```
选项 | 类型 | 描述 
---|---|---
`path` | `string` | 指定要拆分的字段，必须以`$`为前缀
`includeArrayIndex` | `string` | 数组索引的名称
`preserveNullAndEmptyArrays` | `boolean` | 值为`true`时，当要拆分的字段找不到或者为空（null或者空数组），那么会返回未拆分前的文档； 值为`true`时，当要拆分的字段找不到或者为空（null或者空数组）,不会返回文档

### 分组操作符(`$group`)

[`$group`](https://docs.mongodb.com/manual/reference/operator/aggregation/group/)操作符可以将文档依据`_id`中指定的表达式来分组。语法：

```js
{
  $group:
    {
      _id: <expression>, // Group By Expression
      <field1>: { <accumulator1> : <expression1> },
      ...
    }
 }
```
选项 | 描述 
---|---
`_id` | 必须指定，这是分组的依据，可以设置成`null`
field | 可选，可以配合[分组操作符](https://docs.mongodb.com/manual/reference/operator/aggregation/group/#accumulators-group)

## <a id="operation"></a>聚合操作符

### <a href="operation-math"></a>[数学操作符](https://docs.mongodb.com/manual/reference/operator/aggregation/)

操作符 | 语法 | 描述 | 版本 | 例子
---|---|---|---|---|
[`$abs`](https://mongoing.com/docs/reference/operator/aggregation/abs.html#exp._S_abs) | `{ $abs: <number> }` | 返回绝对值 | 3.2+
[`$add`](https://mongoing.com/docs/reference/operator/aggregation/add.html#exp._S_add) | `{ $add: [ <expression1>, <expression2>, ... ] }` | 接受一个或多个表达式，将这些表达式相加 | -
[`$ceil`](https://mongoing.com/docs/reference/operator/aggregation/ceil.html#exp._S_ceil) | `{ $ceil: <number> }` | | 3.2+
[`$divide`](https://mongoing.com/docs/reference/operator/aggregation/divide.html#exp._S_divide) | `{ $divide: [ <expression1>, <expression2> ] }` | 用第一个表达式的值除以第二个表达式的值的商作为结果返回 | - | 
[`$floor`]() | | 
[`$mod`]() | 
[`$multiply`]() |
[`$pow`]() |
[`$sqrt`]() |
[`$subtract`]() |

### <a id="operation-logic"></a>[逻辑操作符](https://mongoing.com/docs/reference/operator/aggregation-boolean.html)

操作符 | 语法 | 描述 | 版本 | 例子
---|---|---|---|---|

### <a id="operation-compare"></a>[比较操作符](https://mongoing.com/docs/reference/operator/aggregation-comparison.html)

操作符 | 语法 | 描述 | 版本 | 例子
---|---|---|---|---|

### <a id="operation-string"></a>[字符串操作符](https://mongoing.com/docs/reference/operator/aggregation-string.html)

操作符 | 语法 | 描述 | 版本 | 例子
---|---|---|---|---|

### <a id="operation-string"></a>[日期操作符](https://mongoing.com/docs/reference/operator/aggregation-date.html)

操作符 | 语法 | 描述 | 版本 | 例子
---|---|---|---|---|

### <a id="operation-condition"></a>[条件操作符](https://mongoing.com/docs/reference/operator/aggregation-conditional.html)

操作符 | 语法 | 描述 | 版本 | 例子
---|---|---|---|---|

### <a id="operation-group"></a>[分组操作符](https://mongoing.com/docs/reference/operator/aggregation-group.html)

操作符 | 语法 | 描述 | 版本 | 例子
---|---|---|---|---|

