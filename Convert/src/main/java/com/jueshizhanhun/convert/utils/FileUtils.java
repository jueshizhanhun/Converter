package com.jueshizhanhun.convert.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



public class FileUtils {
	
	/**获得.前面的名字*/
	public static String getFilePrefix(String fileName){
		int splitIndex = fileName.lastIndexOf(".");
        return fileName.substring(0, splitIndex);
	}
	/**获得.后面的格式*/
	public static String getFileSufix(String fileName){
		int splitIndex = fileName.lastIndexOf(".");
        return fileName.substring(splitIndex + 1);
	}
	/** 复制一个文件 */
	public static void copyFile(String inputFile,String outputFile) throws FileNotFoundException{
		File sFile = new File(inputFile);
		File tFile = new File(outputFile);
		FileInputStream fis = new FileInputStream(sFile);
		FileOutputStream fos = new FileOutputStream(tFile);
		int temp = 0;  
        try {  
			while ((temp = fis.read()) != -1) {  
			    fos.write(temp);  
			}
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally{
            try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        } 
	}
	
}
