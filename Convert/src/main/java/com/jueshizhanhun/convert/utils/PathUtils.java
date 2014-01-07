package com.jueshizhanhun.convert.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;



public class PathUtils {
	
	/**
     * @描述 Maven项目中，获取项目路径
     * @时间 2013-7-26 下午5:13:02
     * @return 项目路径。如：D:\development\github\project\Convert\
     */
    public static String getMavenWebProjectPath(String path) {
        Resource resource = new ClassPathResource("../../");
        String filePath = "";
        try {
            filePath = resource.getFile().getAbsolutePath() + path;
        } catch (IOException e) {
            e.printStackTrace();
        }
       // filePath = filePath.substring(0, filePath.indexOf("target"));
       // filePath = filePath+"src\\main\\webapp\\resources\\docs\\";
        return filePath;
    }
    
    /**
     * 创建目录
     */
    public static void createDir(String filePath) {
        File myFile = new File(filePath);
        if (!myFile.exists()) {
            myFile.mkdirs();
        }
    }
    	/**
    	 * 判断路径是否为空
    	 * @param path
    	 * @return
    	 * @创建人 PengBo
    	 * @创建时间 2014-1-6  上午10:47:08
    	 */
	  public synchronized static boolean existPath(String path) { 
		    File file = new File(path); 
		    if (!file.isFile()) { 
		      return false; 
		    } 
		    return true; 
		  } 
	  /**
	   * 判断是否存在路径不存在则创建目录
	   * @param path 根路径以外的路径
	   * @创建人 PengBo
	   * @创建时间 2014-1-6  上午11:34:00
	   */
	  public static String getPath(String path){
		  path = getMavenWebProjectPath(path);
		  if (!existPath(path)) {
	        	PathUtils.createDir(path);
	        	System.out.println(path);
	        	System.out.println("创建该目录！");
	        	return path;
			}
		return null;
	  }
    public static void main(String[] args) {
		System.out.println(getMavenWebProjectPath("\\resources\\docs\\"));
		System.out.println(existPath(getMavenWebProjectPath("\\resources\\docs\\")));
        if (!existPath(getMavenWebProjectPath("\\resources\\docs\\"))) {
        	PathUtils.createDir(getMavenWebProjectPath("\\resources\\docs\\"));
        	System.out.println("ok");
		}
	}
}
