package com.bihe0832.png;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.imageio.ImageIO;

public class getPNGInfo {

	private static final int VERSION_CODE = 1;
	private static final String VERSION_NAME = "1.0.0";
	private static final String HELP_PAGE_GENERAL = "help.txt";
	private static final String VERSION_PAGE_GENERAL = "help_version.txt";
	
	private static final int RET_SUCC = 0;
	private static final int RET_FILE_NOT_EXIST = -1;
	private static final int RET_GET_INFO_FAILED = -2;
	
	public static final String KEY_RESULT_RET = "ret";
	public static final String KEY_RESULT_MSG = "msg";
	public static final String KEY_RESULT_HAS_ALPHA = "hasAlpha";
	public static final String KEY_RESULT_IMG_TYPE = "type";
	public static final String KEY_RESULT_IMG_WIDTH = "width";
	public static final String KEY_RESULT_IMG_HEIGHT = "height";
	public static final String KEY_RESULT_IMG_SIZE = "size";
	
	public static void main(String[] params) throws Exception {
        if ((params.length == 0)) {
            printUsage(HELP_PAGE_GENERAL);
            return;
        }
        if (params[0].toLowerCase().startsWith("--help")) {
            printUsage(HELP_PAGE_GENERAL);
            return;
        } else if (params[0].toLowerCase().startsWith("--version")) {
    		System.out.println(getPNGInfo.class.toString() + " version " + VERSION_NAME + " (" + VERSION_CODE + ")\n");
    		printUsage(VERSION_PAGE_GENERAL);
            return;
        } else{
        	getPNGInfoByPath(params[0]);
			return;
		}
    } 
	
	public static void getPNGInfoByPath(String filepath){
		File tempImg = new File(filepath);
		if(tempImg.exists()){
			try {
				BufferedImage img = ImageIO.read(tempImg);
				System.out.println("{\""+ KEY_RESULT_RET +"\":" + RET_SUCC +
										",\""+ KEY_RESULT_MSG +"\":\"" +  
											"图片是否有渐变: " + img.getColorModel().hasAlpha() + " ,"+  
											"图片尺寸为(宽*高): " + img.getWidth() + " * " +  img.getHeight() + " , " +  
											"图片大小: " + tempImg.length() / 1024 + " KB,"+  
											"图片类型: " + img.getType() + "\"" +
										",\""+ KEY_RESULT_HAS_ALPHA +"\":" +  img.getColorModel().hasAlpha() + 
										",\""+ KEY_RESULT_IMG_TYPE +"\":" +  img.getType() + 
										",\""+ KEY_RESULT_IMG_WIDTH +"\":" +  img.getWidth() + 
										",\""+ KEY_RESULT_IMG_HEIGHT +"\":" +  img.getHeight() + 
										",\""+ KEY_RESULT_IMG_SIZE +"\":" +  tempImg.length() / 1024 + 
								"}\n"); 
			} catch (Exception e) {
				printFailedCheckResult(RET_GET_INFO_FAILED," get file :" + filepath +" info failed");
			}
		}else{
			printFailedCheckResult(RET_FILE_NOT_EXIST," file :" + filepath +" is not exist");
		}
	}
	
	private static void printFailedCheckResult(int ret,String Msg){
		System.out.println("{\""+ KEY_RESULT_RET +"\":" + ret + ",\""+ KEY_RESULT_MSG +"\":\"" + Msg + "\"}\n"); 
	}
	
	private static void printUsage(String page) {
        try (BufferedReader in =
                new BufferedReader(
                        new InputStreamReader(
                                getPNGInfo.class.getResourceAsStream(page),
                                StandardCharsets.UTF_8))) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read " + page + " resource");
        }
    }

    private static class ParameterException extends Exception {
        private static final long serialVersionUID = 1L;
        ParameterException(String message) {
            super(message);
        }
    }
}
