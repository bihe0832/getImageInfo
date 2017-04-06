package com.bihe0832.img;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.tinify.Source;
import com.tinify.Tinify;

public class tinyjpg {
	private static final int VERSION_CODE = 1;
	private static final String VERSION_NAME = "1.0.0";
	private static final String HELP_PAGE_GENERAL = "help.txt";
	private static final String VERSION_PAGE_GENERAL = "help_version.txt";
	private static final String EVN_PAGE_GENERAL = "help_env.txt";
	
	private static boolean hasSetApiKey = false;
	
	public static void main(String[] params) throws Exception {
        if ((params.length == 0)) {
            printUsage(HELP_PAGE_GENERAL);
            return;
        }
        if (params[0].toLowerCase().startsWith("--help")) {
            printUsage(HELP_PAGE_GENERAL);
            return;
        } else if (params[0].toLowerCase().startsWith("--version")) {
    		System.out.println(tinyjpg.class.toString() + " version " + VERSION_NAME + " (" + VERSION_CODE + ")\n");
    		printUsage(VERSION_PAGE_GENERAL);
            return;
        }  else if (params[0].toLowerCase().startsWith("--env")) {
			printUsage(EVN_PAGE_GENERAL);
	        return;
	    } else {
    		compressImg(params[0]);
			return;
		}
    } 
	
	public static void compressImg(String sourceFilepath){
		
		Map map = System.getenv();  
		Iterator it = map.entrySet().iterator();  
		while(it.hasNext()) {  
		    Entry entry = (Entry)it.next();
		    if("tinypng_api_key".equals(entry.getKey().toString().toLowerCase())){
		    	System.out.println("tinypng_api_key:" + entry.getValue());
		    	Tinify.setKey(entry.getValue().toString());
		    	hasSetApiKey = true;
		    }
		    
		    if("http_proxy".equals(entry.getKey().toString().toLowerCase())){
		    	System.out.println("http_proxy:" + entry.getValue() + "\n");
		    	Tinify.setProxy(entry.getValue().toString());
		    }
		}  
		
		if(!hasSetApiKey){
			System.out.println("tinypng_api_key not found, please enter \n\n\t java -jar ./tinypngDemo.jar --env \n\nfor more info");
			return;
		}
		File tempImg = new File(sourceFilepath);
		if(tempImg.exists()){
			try {
				Source source = Tinify.fromFile(tempImg.getAbsolutePath());
				String sourceFileExtension = tempImg.getAbsolutePath().substring(tempImg.getAbsolutePath().lastIndexOf("."));
				String sourceFileName = tempImg.getAbsolutePath().substring(0,tempImg.getAbsolutePath().lastIndexOf("."));
				String targetFilePath = sourceFileName + "_optimized" + sourceFileExtension;
				source.toFile(targetFilePath);
				File resultImg = new File(targetFilePath);
				if(resultImg.exists()){
					System.out.println("file unoptimized size: " + tempImg.length());
					System.out.println("file optimized: " + targetFilePath);
					System.out.println("file optimized size: " + resultImg.length());
					float compressPercent = (float)resultImg.length() / (float)tempImg.length();
					System.out.println("file compress percentage: " +  (1 - compressPercent) * 100 + "%" );
				}else{
					System.out.println(" optimize file :" + sourceFilepath +" failed");
				}
			} catch (Exception e) {
				System.out.println(" optimize file :" + sourceFilepath +" failed");
			}
		}else{
			System.out.println(" file :" + sourceFilepath +" is not exist");
		}
	}
	
	private static void printUsage(String page) {
        try (BufferedReader in =
                new BufferedReader(
                        new InputStreamReader(
                        		tinyjpg.class.getResourceAsStream(page),
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

