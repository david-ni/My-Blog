# Js 整数的安全范围

Javascript中能“安全”的表示数字的范围是在`-(2^53 - 1)`到`2^53 - 1`之间。我们可以用`Number.MAX_SAFE_INTEGER`和`Number.MIN_SAFE_INTEGER`分别获取到最大和最小安全值。

> 本文中安全是指能够准确地表示整数和正确地比较整数，比如 Number.MAX_SAFE_INTEGER + 1 === Number.MAX_SAFE_INTEGER + 2 将返回 true。这在数学上并不正确。

看到这里你是否有所疑问：为什么安全范围是2^53 - 1 而不是2^64或者其他呢？本文的目的就是为了解决上述问题。

在进一步深入之前，我们有必要了解一下，小数是在计算机中是如何存储的。

## 小数转换成二进制浮点数

> 根据国际标准IEEE 754，任意一个二进制浮点数V可以表示成下面的形式：V = (-1)^s * M * 2E 
> 其中s表示符号位，当s=0，V为正数；当s=1，V为负数。
> M表示有效数字，M>=1&&M<=2。
> 2^E表示指数位。

举个例子：78.375，现在分成三步把它转换成我们想要的内容：

1. 将整数（78）部分转换成二进制数：1001110
2. 将小数部分（0.375）转换成二进制：0.011
3. 现在我们得到78.375的二进制表示为1001110.011，将这个结果用二进制科学技术法表示为1.001110011*2^6 

这个例子中，s的值为0，M的值为1.001110011，E的值为6

## 在计算机中存储

与大部分现代编程语言一样，Javascript中的数字类型是基于IEEE 754标准来实现的，该标准通常也称之为“浮点数”。标准定义了四种浮点数方式：单精确度（32位）、双精确度（64位）、延伸单精确度（43比特以上，很少使用）与延伸双精确度（79比特以上，通常以80位实现）。而Javascript使用的是双精度格式。

如下图所示，对于64位的浮点数，最高的1位是符号位S，接着的11位是指数E，剩下的52位为有效数字M。

![js-safe-integer-1](Assets/Js-Safe-Integer-01.png)

对于上面的例子：符号位s(signal bit)存储的是0，指数位e（exponent）存储的是6偏差值后的二进制表示，尾数位M（mantissa）存储的是001110011。

这里需要说明的是：对于尾数位M（1.xxxxxx）而言，因为其整数位始终未1，因此IEEE 754规定，在计算机内部保存M时，舍去整数位1，只保存后面的xxxxxx部分。

## 小结一下

经过以上的分析，我们可以得到以下结论：

- 指数位决定了大小范围，指数位能表示的数越大则能表示的数越大
- 而尾数位决定了计算精度，尾数位能表示的数越大，则能计算的精度越大

现在回顾一下，开篇我们对于“安全”的定义

> 安全是指能够准确地表示整数和正确地比较整数

这里抓住一个关键词“准确”，也就是整数的安全范围关心的是精度而不是大小。那么根据前面所阐述的，对于双精度浮点数而言，它最多可以存储52位的有效数字，即最大数值为
2^0 + 2^1 + .......+ 2^51 + 2^52 = 2^53 - 1 

## 参考

1. [浮点数的二进制表示](http://www.ruanyifeng.com/blog/2010/06/ieee_floating-point_representation.html)
2. [IEEE 754](https://zh.wikipedia.org/wiki/IEEE_754#64%E4%BD%8D%E9%9B%99%E7%B2%BE%E5%BA%A6)
3. [为什么在js中Number.MAX_VALUE + 1不是Infinity](https://www.zhihu.com/question/24423421)