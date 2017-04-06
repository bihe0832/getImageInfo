## 简介

getImageInfo 是几款个人基于Java编写的获取图片信息（大小、透明度以及编码方案）、图片压缩等的工具，方便在命令行处理图片。

### 目录介绍

	├── README.md	：项目介绍
	│
	├── head.jpg：非透明渐变图片事例
	│
	├── head.png：透明渐变图片事例
	│
	├── getImgInfo.jar：查看图片基本信息（大小、透明度以及编码方案）的可执行jar
	│
	├── getImgInfo：getImgInfo.jar源码
	│
	├── tinyjpg.jar：封装了tinyjpg，支持HTTP代理的图片压缩SDK的可执行jar
	│
	└── tinyjpg：tinyjpg.jar的源码

## 使用事例

这里仅介绍核心用法，详细的用法请参照工具对应目录下的README文件

### getImgInfo.jar

	➜  getPNGInfo git:(master) ✗ java -jar ./getImgInfo.jar head.jpg
	{"ret":0,"msg":"图片是否有渐变: false ,图片尺寸为(宽*高): 344 * 344 , 图片大小: 7 KB,图片类型: 5","hasAlpha":false,"type":5,"width":344,"height":344,"size":7}
	
	➜  getPNGInfo git:(master) ✗ java -jar ./getImgInfo.jar head.png
	{"ret":0,"msg":"图片是否有渐变: true ,图片尺寸为(宽*高): 344 * 344 , 图片大小: 33 KB,图片类型: 6","hasAlpha":true,"type":6,"width":344,"height":344,"size":33}

### tinyjpg.jar

	➜  getPNGInfo git:(master) ✗ java -jar ./tinyjpg.jar ~/temp/1/head.jpg
	tinypng_api_key:QVFA4tI-IBD6Ge4gcCqQX44xTderwr1f
	http_proxy:http://dev-proxy.oa.com:8080
	
	file unoptimized size: 8037
	file optimized: /Users/hardyshi/temp/1/head_optimized.jpg
	file optimized size: 4895
	file compress percentage: 39.094193%
			
## 相关文章

- [如何生成混淆过的可执行的jar程序](http://blog.bihe0832.com/runnable-jar.html)

- [iMac下制作含透明度图片及判断图片透明度](http://blog.bihe0832.com/png_alpha.html)