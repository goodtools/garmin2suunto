### 背景

作为garmin和keep的重度用户，一直受困于2者之间的数据不能同步，以至于每次跑步都必须揣着手机，十分不爽。不过最近keep和suunto数据上打通了，加上之前无意在知乎 https://www.zhihu.com/question/46991660 上发现garmin的数据其实可以通过接口写入到suunto里去的，这些基础条件的成熟触发了这个项目的落地

#### 为什么要再造轮子

1. mxactivitymover提供的是一个jar版本的程序，基于桌面版，现在跑友们都是拿着手机，十分不方便
2. 程序对我来说有些bug，主要是时区的区别， mxactivitymover 取的时间用的是标准时间，而我们再东8区，导致sunnto的运动记录被提前了8小时
3. 操作相对来说还是不是特别方便，估计也很久没做更新维护了

### 目标

方便跑友们快速的把garmin产生的运动数据同步到suunto上去，方遍其他第三方程序再从sunnto同步，比如keep

### 实现

1. 根据时间倒排序获取garmin中的运动记录
2. 再到suunto的服务器上读相应的运动记录，如果记录匹配，则表示同步完成，如果未匹配进入下一步
3. 同步数据
	1. 根据garmin的运动id获取运动数据详情，包括splites和details
	2. 根据mxactivitymover提供的接口，将garmin的数据转换到suunto的数据结构
	3. 调用sunnto的接口进行记录保存

### 操作指南

[youku视频](https://v.youku.com/v_show/id_XMzk5NzAzMDA2OA==.html)

![actions](./apks/mix.jpg)


#### 设置

#### GARMIN账号密码

garmin connect提供的http接口的身份认证方式是cookie，而写入cookie又必须依赖于在garmin的sso登录页面传入用户名和密码，
所以为了正确的从garmin拿到接口数据，必须填写。

#### suunto账号和key

suunto的授权方式比较简单，是通过key的方式，当一个新的key（uuid）+ 账号 通过接口访问suunto服务的时候，suunto会生成一个授权请求，
用户必须亲自手动的接受授权才能做正确的通讯，请务必注意:
[http://www.movescount.com/settings#connections](http://www.movescount.com/settings#connections)

#### 下载

[1.0](./apks/g2m-1.0.apk)

### 致谢

1. 感谢mxactivitymover为我提供了api的调用参考
2. 感谢garmin和suunto提供的api接口
3. 感谢开源
	* [RxJava](https://github.com/ReactiveX/RxJava) 一个专注于异步编程与控制可观察数据（或者事件）流的API
	* [RxAndroid](https://github.com/ReactiveX/RxAndroid) 为了在Android中使用RxJava
	* [Retrofit](https://github.com/square/retrofit) 安全的HTTP请求工具库
	* [material-about-library](https://github.com/daniel-stoneuk/material-about-library) 让你更容易的创建美丽的关于页面
	* [spots-dialog](https://github.com/d-max/spots-dialog) 让你更容易的创建加载动画
