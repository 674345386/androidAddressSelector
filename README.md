# androidAddressSelector
### 仿京东客户端的地址选择器,参照别人实现的基础上，持续自己修改一些更加友好性的小地方，依赖库放置于自己的jitpack，方便用于测试开发，使一同开发的同学不用再merge自己的branch，修改依赖版本号即可。

1）内置数据库，使用DBflow数据库orm,注解建表 https://github.com/Raizlabs/DBFlow
2）无注入实现，简单依赖，实现选择回调即可
3）两种样式选择

ps：mainActivity，secondActivity展示为不同的使用地址选择器方法，使用时，根据自己的activity实现依赖library库即可

**使用方法**：

Step 1. Add the JitPack repository to your build file


（使用的是jitpack，https://jitpack.io/）
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency

	dependencies {
	        compile 'com.github.674345386:androidAddressSelector:v1.3'
	}



Reference: https://github.com/chihane/JDAddressSelector
