我从 [GitHub](https://github.com/jiawn/onenet) 上找到了这样一个例子，使用 SpringBoot + Swagger 技术，连接 OneNET 平台，从 OneNET 平台获取数据。

## 一、所需环境
1. jdk 1.8
2. maven 3.0+，构建工具
3. mysql 5.5+，数据库
4. IDE 工具，Eclipse 4.0+，或者 IDEA
5. git 1.7+，代码版本管理工具

## 二、导入项目

如果是 IDEA，则直接导入项目，选择 pom.xml 即可。

如果是 Eclipse，在终端中执行下面命令，转成Eclipse工程，即可导入到Eclipse中：
```
mvn eclipse:eclipse
```

修改 *onenet\src\main\resources\application.yml* 中的 MySQL 用户名和密码，以及 OneNET 的配置：

```
cmcc:
  onenet:
    drivceid: 39333785
    api-key: 9UEjFtzBsVdbfr6DaV9VvLM3kos=
```

这个 `drivceid` 表示设备ID（名字为笔误，懒得改代码了），可以从 OneNET 控制台的“设备列表”中获取。ApiKey 则为设备所属产品的属性，可以从“产品概况”中获取。

	
## 三、启动

- Eclipse 中，直接 `run Launch.java`
- IDEA 中，运行 *onenet\src\main\java\com\cmcc\onenet\Launch.java* 中的 `main()` 函数，即可启动整个项目。
	
## 四、访问

访问 http://localhost:8081/swagger-ui.html 即可以查看项目实现的 API。目前项目实现了两个 API，新增和查询。

<center>![image_1d9fm3u451oae9p8hsq1qnhcte9.png-101kB][1]</center>

点开查询，在默认参数那里单击一下，就可以将默认参数填入输入框中（Chrome 可以，Firefox 不行）。

<center>![image_1d9fm85r93ae8h7mjb9av8dim.png-189.2kB][2]</center>

修改成我们的实际参数，如下：

```
{
  "cursor": 0,
  "datastreamId": "3303_0_5700",
  "deviceId": 39333785,
  "duration": 0,
  "end": "2019-04-27T15:06:56.891Z",
  "limit": 0,
  "sort": "DESC",
  "start": "2018-04-27T15:06:56.891Z"
}
```

然后点击“Try it out!”，就可以获取到传感器的值了。3303 表示温度传感器：

```
{
  "errno": 0,
  "data": {
    "count": 3,
    "datastreams": [
      {
        "datapoints": [
          {
            "at": "2019-04-27 23:24:25.283",
            "value": 26.08
          }
        ],
        "id": "3303_0_5700"
      },
      {
        "datapoints": [
          {
            "at": "2019-04-27 23:24:25.300",
            "value": 40.417271
          }
        ],
        "id": "3304_0_5700"
      },
      {
        "datapoints": [
          {
            "at": "2019-04-27 23:24:25.150",
            "value": 5.833333
          }
        ],
        "id": "3301_0_5700"
      }
    ]
  },
  "error": "succ"
}
```

## 五、目录说明

|目录|说明
|-|-
|*src/main/java/\*/constants*|系统常量
|*src/main/java/\*/config*|系统配置
|*src/main/java/\*/controller*|请求层
|*src/main/java/\*/controller/request*|请求层的请求数据
|*src/main/java/\*/controller/response*|请求层的响应数据
|*src/main/java/\*/domain*|实体
|*src/main/java/\*/domain/repository*|访问数据库
|*src/main/java/\*/domain/enums*|实体使用的枚举
|*src/main/java/\*/exception*|平台定义异常
|*src/main/java/\*/interceptor*|拦截器
|*src/main/java/\*/service*|服务层，封装各个业务的处理
|*src/main/java/\*/util*|工具类
|*src/main/resources/application.yml*|系统具体配置项文件
|*src/main/resources/log.xml*|系统日志配置


  [1]: http://static.zybuluo.com/morgen/8h8ihe9mtolzrh0plknxzupy/image_1d9fm3u451oae9p8hsq1qnhcte9.png
  [2]: http://static.zybuluo.com/morgen/zkcpd4okmewy8ybl2kkds13e/image_1d9fm85r93ae8h7mjb9av8dim.png
