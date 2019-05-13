## 待完成的点：
### 基础功能
1.权限管理后台  
2.第三方登录  
3.单点登录  
4.前端(参考文档 %50)  
5.spring security集成  



### 可维护性
1.admin未加集群监控  
2. 灰度调用  
3.jekens  
4.Docker打包项目  
5.Nepxion Discovery集成  
6.pom.xml文件包需要整理到父类  

### 已完成
1.基础的mybatis,统一异常处理机制（ok）  
2.jedis + redis (ok)  
3. rabbit通信(ok)  
4.zuul路由过于简单(ok)  
5.限流功能(ok)  
6.swagger(ok)  

## swagger接入
   参考Hello-customer及文档

## 加入vue.js
   加入前端项目模板
   移步 https://github.com/HanJuly/hw-front-vue/

## Zuul 更换为gateway，并使用Redis进行限流

## 配置自定义错误页面和统一的异常处理
   已加入Common模块，其他模块导入并配置扫描即可使用  
   参考：  
      hello-service配置  
      博客：https://www.jianshu.com/p/3998ea8b53a8  

## 加入nginx方式访问rabbitmq
  文档参考document+tools  
  配置改为nginx端口地址即可  
  rabbitmq通讯参考hello-customer与hello-service  
  具体参考以下类：  
    RabbitConfig,TestRabbitmqController,RabbitReciever  S

## 加入jedis工具,在common中。
 其他模块使用pom.xml配置方式使用。  
 以后公共的接口，工具类都放在这里。

## Common模块使用方式
 1.首先将common模块mvn install  
 2.pom.xm加入依赖  
 3.在yaml文件中配置redis配置
 4.指定扫描包
参考hello-customer  


## document+tools目录介绍
1.pdf上传学习的书  
2.tools上传网上不好下在的工具或者源码包  
3.error-log上传搭建环境遇到的坑或者其他的坑



