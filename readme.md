# 石大易查询(学生信息查询系统)

## 这是什么?

石大易查询是为中国石油大学(华东)开发的查询空教室/成绩/课表/一卡通消费情况的一款 **轻应用**.

## 信息来源

学生学号/姓名信息来源于易班开放平台API,通过oauth2.0协议授权获取.成绩/课表/教室/一卡通信息通过学校提供的webservice获取.该webservice仅可在指定ip上调用.

## 开发进度

一期 3/3 查空教室,查成绩,查课程  已完工.
二期 筹备中.

## 项目说明

### 后端部分:
后端采用Java语言编写,springboot框架.maven作为依赖管理,构建工具.数据来源:学校提供的一个webservice.

后端部分解释:

config类里有申请自易班开放平台的appid和appsecret,不同步至github.

controller层负责顶层用户逻辑,service层提供具体实现.service类一般有对应的测试类.

util层中封装了调用webservice的方法及对易班授权返回的加密信息的解密方法.

gsontemplate包里是用gson解析json需要的模板类.

### 前端部分:
前端采用yeoman生成项目骨架,bower进行前端依赖管理,gulp作为自动构建工具.

前端使用semantic-ui作为框架,写了最基本的架子.

前端续开发流程:拉取仓库到本地,cd进入fontend目录,npm install,bower install,gulp server.

## 维护说明
项目维护分接口维护和程序逻辑维护.交接时会给配置类.接口维护主要在接口变化时和学校网络中心老师交涉.此外简单的维护包括对SchoolDateUtil类的修改,计算周数需要修改学期的开始时间.