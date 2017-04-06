### 查看帮助

	➜  getPNGInfo git:(master) ✗ java -jar ./tinyjpg.jar
	usage:
	
		java -jar ./tinyjpg.jar <command> [sourceFilePath] [targetFilePath]
		java -jar ./tinyjpg.jar --version
		java -jar ./tinyjpg.jar --help
		java -jar ./tinyjpg.jar --env
	
	such as:
	
		java -jar ./tinyjpg.jar ./test.png ./test_optimized.png
		java -jar ./tinyjpg.jar --version
		java -jar ./tinyjpg.jar --help			
			
### 查看版本

	➜  getPNGInfo git:(master) ✗ java -jar ./tinyjpg.jar --version
	class com.bihe0832.img.tinypngDemo version 1.0.0 (1)
	
	homepage : https://github.com/bihe0832/getImageInfo
	blog : http://blog.bihe0832.com
	github : https://github.com/bihe0832
	
### 如何设置环境变量

	➜  getPNGInfo git:(master) ✗ java -jar ./tinyjpg.jar --env
	tinypngDemo need your own api key get from tinypng homepage.
	If you don't have one, you can get from it's homepage:
	
		https://tinypng.com/developers
	
	after you get your own api key, you need to add it to your evn.
	for iMac user, just input this command to you command line:
	
		export tinypng_api_key=YOUR_API_KEY
	
	if your server has an http proxy,just add is to your evn too.
	for iMac user, just input this command to you command line:
	
		export http_proxy='http://your.proxy.com:8080'

- 特别说明

**由于tinypng官方的限定，使用SDK之前一定要先申请`API_KEY`，申请方法上文已经有说明。申请到的`api_key`，以及网络请求代理都通过环境变量的形式设置，程序运行时会从环境变量读取**。
		
### 压缩图片

	➜  getPNGInfo git:(master) ✗ java -jar ./tinyjpg.jar ~/temp/1/head.jpg
	tinypng_api_key:QVFA4tI-IBD6Ge4gcCqQX44xTdQTay1f
	http_proxy:http://dev-proxy.oa.com:8080
	
	file unoptimized size: 8037
	file optimized: /Users/hardyshi/temp/1/head_optimized.jpg
	file optimized size: 4895
	file compress percentage: 39.094193%
		


