# Js事件循环

对于`Event Loop` HTML Standard有如下定义：

> To coordinate events, user interaction, scripts, rendering, networking, and so forth...Each agent has an associated event loop, which is unique to that agent.

简而言之`Event Loop`是一个任务调度中心，用于协调事件、用户交互、脚本、渲染、网络请求等等这些任务。

`Event Loop`可以分为三类：

- Window Event Loop（通常所指的）
- Worker Event Loop
- Worklet Event Loop

`Window Event Loop`是最经常涉及的，也是我们后面所指代的，每打开一个浏览器界面通常就对应一个`Event Loop`，而`Worker`是Js中线程创建的方法，相当于Java中的`Thread`，`Worklet`还处于草案阶段，主要应用于需要超高性能场景（ `Worklet` 中跑的是机器码而不是Js ）。

根据[Html Stardard](https://html.spec.whatwg.org/#event-loop-processing-model)，Event Loop的执行通常涉及到以下几个步骤：

1. 从多个宏任务队列中选择可执行的队列，并执行其中最老的任务
2. 执行当前所有微任务
3. 如果机会合适，渲染视图
4. 如果还有未执行的任务，则继续循环执行步骤1～3

## 宏任务和微任务

<b>宏任务</b>(macrotasks)，每次`Event Loop`只会从宏任务队列中取出一个任务执行，`setTimeout`, `setInterval`, `setImmediate`, `requestAnimationFrame`, `I/O`, `UI rendering`都是属于宏任务。

<b>微任务</b>(microtasks), `Event Loop`对此类任务比较慷慨，每次循环都会将现有微任务执行完毕。`Promises`, `MutationObserver`都是微任务。

## 其他资料

- Philip Roberts 关于[Event Loop的演讲](https://www.youtube.com/watch?v=8aGhZQkoFbQ)，重点推荐
- [Event Loop 可视化工具](http://latentflip.com/loupe/?code=JC5vbignYnV0dG9uJywgJ2NsaWNrJywgZnVuY3Rpb24gb25DbGljaygpIHsKICAgIHNldFRpbWVvdXQoZnVuY3Rpb24gdGltZXIoKSB7CiAgICAgICAgY29uc29sZS5sb2coJ1lvdSBjbGlja2VkIHRoZSBidXR0b24hJyk7ICAgIAogICAgfSwgMjAwMCk7Cn0pOwoKY29uc29sZS5sb2coIkhpISIpOwoKc2V0VGltZW91dChmdW5jdGlvbiB0aW1lb3V0KCkgewogICAgY29uc29sZS5sb2coIkNsaWNrIHRoZSBidXR0b24hIik7Cn0sIDUwMDApOwoKY29uc29sZS5sb2coIldlbGNvbWUgdG8gbG91cGUuIik7!!!PGJ1dHRvbj5DbGljayBtZSE8L2J1dHRvbj4%3D) 可以配合视频一起
- [Difference between microtask and macrotask within an event loop context](https://stackoverflow.com/questions/25915634/difference-between-microtask-and-macrotask-within-an-event-loop-context)
- [Tasks, microtasks, queues and schedules](https://jakearchibald.com/2015/tasks-microtasks-queues-and-schedules/?utm_source=html5weekly)
- [从Promise来看JavaScript中的Event Loop、Tasks和Microtasks](https://github.com/creeperyang/blog/issues/21)
- [从 event loop 规范探究 javaScript 异步及浏览器更新渲染时机](https://gitlwz.github.io/2019/04/03/js-requestIdleCallback/)

