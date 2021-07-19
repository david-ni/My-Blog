# React Hook

React 16.8发布Hook特性已一年有余，笔者也在多个项目中有所应用。但对React Hook内部原理还是一知半解，趁着这段时间有空，梳理成文。

 ## 为什么要使用Hooks?

> [React Hook Motivation](https://reactjs.org/docs/hooks-intro.html#motivation)

React声明定义组件的方式有两种：类组件和函数组件，但这两种方式都有缺陷。

对于函数组件而已，虽然简洁，但往往不够用：

- 没有声明周期函数
- 不支持内部state

而类组件虽然没有函数组件的烦恼，不过也存在：

- 不如函数组件简洁

- 非UI逻辑难以复用

  > [非UI逻辑难以复用的例子](https://zhuanlan.zhihu.com/p/137183261)

如何兼顾简洁，又不至于缺胳膊少腿呢？

Hooks踩着七彩祥云而来...

## Hooks 的规则

- 请不要在循环、条件或者嵌套函数中调用 Hooks
- 都有在 React 函数中才去调用 Hooks

## 排疑解惑

1. 为什么不能在循环、条件或者嵌套函数中调用 Hooks？

> [(译)React hooks：它不是一种魔法，只是一个数组——使用图表揭秘提案规则](https://juejin.cn/post/6844903721688629256)

Hooks军规第一条：**循环、条件或者嵌套函数中调用 Hooks**，满脑子问号emoji

2. Hooks 是如何确定依赖变化的？

## 参考

1. [为什么顺序调用对 React Hooks 很重要？](https://overreacted.io/zh-hans/why-do-hooks-rely-on-call-order/)
2. [Rules of Hooks](https://reactjs.org/docs/hooks-rules.html)
3. [React Hooks源码解析，原来这么简单～](https://juejin.cn/post/6844904080758800392)