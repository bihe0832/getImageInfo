## 背景

### APK Signature Scheme v2官方介绍


- `TYPE_CUSTOM` = 0

	图像类型无法识别，因此它必须是自定义图像。
	
- `TYPE_INT_RGB` = 1

	表示具有8位RGB颜色分量的整数像素的图像，他没有alpha值。

- `TYPE_INT_ARGB` = 2

	表示具有8位RGBA颜色成分的整数像素的图像，她有alpha值。
	
- `TYPE_INT_ARGB_PRE` = 3

	表示具有8位RGBA颜色成分的整数像素的图像。
	
- `TYPE_INT_BGR` = 4

	表示具有8位RGB颜色分量的图像，对应于Windows或Solaris样式的BGR颜色模型，蓝色，绿色和红色颜色打包成整数像素。
		
- `TYPE_3BYTE_BGR` = 5

	表示具有8位RGB颜色分量的图像，对应于Windows风格的BGR颜色模型，蓝色，绿色和红色以3个字节存储。

- `TYPE_4BYTE_ABGR` = 6

	表示具有蓝色，绿色和红色的8位RGBA颜色分量的图像，存储在3个字节和1个字节的alpha中。

- `TYPE_4BYTE_ABGR_PRE` = 7

	表示具有蓝色，绿色和红色的8位RGBA颜色分量的图像，存储在3个字节和1个字节的alpha中。

- `TYPE_USHORT_565_RGB` = 8

	表示具有5-6-5 RGB颜色分量（5位红色，6位绿色，5位蓝色），无alpha的图像。

- `TYPE_USHORT_555_RGB` = 9

	表示5-5-5 RGB颜色分量（5位红色，5位绿色，5位蓝色）的图像，无alpha。

- `TYPE_BYTE_GRAY` = 10

	表示无符号字节灰度图像，无索引。

- `TYPE_USHORT_GRAY` = 11

	表示无符号短灰度图像，非索引）。
	
- `TYPE_BYTE_BINARY` = 12 

	表示不透明的字节打包的1,2或4位图像。
	
- `TYPE_BYTE_INDEXED` = 13

	表示索引的字节图像。
 
## 使用事例

#### 查看帮助

	➜  java -jar CheckAndroidV2Signature.jar

	usage: java -jar ./CheckAndroidV2Signature.jar [--version] [--help] [filePath]
	
	such as:
	
		 java -jar ./CheckAndroidV2Signature.jar --version
		 java -jar ./CheckAndroidV2Signature.jar --help
		 java -jar ./CheckAndroidV2Signature.jar ./test.apk
	
	after check,the result will be a string json such as:
	
		 {"ret":0,"msg":"ok","isV2":true,"isV2OK":true}
	
		 ret: result code for check
	
			 0 : command exec succ
			 -1 : file not found
			 -2 : file not an Android APK file
			 -3 : check File signature error ,retry again
	
		 msg: result msg for check
		 isV2: whether the file is use Android-V2 signature or not
		 isV2OK: whether the file's Android-V2 signature is ok or not
			
			
#### 查看版本

	➜  java -jar ./CheckAndroidV2Signature.jar --version
		com.tencent.ysdk.CheckAndroidV2Signature version 1.0.1 (CheckAndroidV2Signature - 2)
		homepage : https://github.com/bihe0832/AndroidGetAPKInfo
		blog : http://blog.bihe0832.com
		github : https://github.com/bihe0832
		
#### 查看应用信息

	➜  java -jar ./CheckAndroidV2Signature.jar ./YSDK_Android_1.3.1_629-debug-ysdktest-inner.apk
	{"ret":0,"msg":"ok","isV2":false,"isV2OK":false}
		

