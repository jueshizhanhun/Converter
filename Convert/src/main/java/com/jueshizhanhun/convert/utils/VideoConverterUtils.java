package com.jueshizhanhun.convert.utils;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


public class VideoConverterUtils {

//	@Autowired
//	private VideoConverter videoConverter;
//	/**
//	 * 带有图片的视频转换
//	 * @param videoPath	上传视频路径
//	 * @param targetPath	转码后视频路径
//	 * @param oldImagePath 上传图片路径
//	 * @param newImagePath 转码后图片路径
//	 * @return
//	 * @创建人 PengBo
//	 * @创建时间 2014-1-6  上午11:09:32
//	 */
//	  public synchronized String process(String videoPath,String targetPath,
//			  String oldImagePath,String newImagePath) { 
//	    int type = checkContentType(videoPath); 
//	    if (type == 0) { 
//	    	targetPath = videoConverter.ffmpegVideoConverter(videoPath, targetPath); 
//	    	if (null != oldImagePath) {
//	    		videoConverter.ffmpegImageConverter(oldImagePath,newImagePath); 
//			}
//	    } else if (type == 1) { 
//	    	targetPath =  videoConverter.mencoderVideoConverter(videoPath,targetPath); 
//	    } else if (type == 2) {
//	    	targetPath = videoPath;
//		} 
//	    return targetPath;
//	  } 
//	  /**
//	   * 视频转码
//	   * @param videoPath	上传视频路径
//	   * @param targetPath	转码后视频路径
//	   * @return
//	   * @创建人 PengBo
//	   * @创建时间 2014-1-6  上午11:10:53
//	   */
//	  public synchronized String process(String videoPath,String targetPath) { 
//	    int type = checkContentType(videoPath); 
//	    if (type == 0) { 
//	    	targetPath = videoConverter.ffmpegVideoConverter(videoPath, targetPath); 
//	    } else if (type == 1) { 
//	    	targetPath = videoConverter.mencoderVideoConverter(videoPath,targetPath); 
//	    } else if (type == 2) {
//	    	targetPath = videoPath;
//		} 
//	    return targetPath;
//	  } 
	
	
	/**
	 * 判断视频格式
	 * @param videoPath
	 * @return 0：需要转换  1：需要2次转换 2:不需要转换 
	 * @创建人 PengBo
	 * @创建时间 2014-1-6  上午10:45:40
	 */
	  public synchronized static  int checkContentType(String videoPath) { 
		    String type = videoPath.substring(videoPath.lastIndexOf(".") + 1, videoPath.length()) 
		        .toLowerCase(); 
		    // ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等） 
		    if (type.equals("avi")) { 
		      return 0; 
		    } else if (type.equals("mpg")) { 
		      return 0; 
		    } else if (type.equals("wmv")) { 
		      return 0; 
		    } else if (type.equals("3gp")) { 
		      return 0; 
		    } else if (type.equals("mov")) { 
		      return 0; 
		    } else if (type.equals("asf")) { 
		      return 0; 
		    } else if (type.equals("asx")) { 
		      return 0; 
		    } 
		    else if (type.equals("mp4")) { 
		      return 2; 
		    } else if (type.equals("flv")) { 
		      return 2; 
		    } 
		    // 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等), 
		    // 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式. 
		    else if (type.equals("wmv9")) { 
		      return 1; 
		    } else if (type.equals("rm")) { 
		      return 1; 
		    } else if (type.equals("rmvb")) { 
		      return 1; 
		    } 
		    return 9; 
		  } 
		/**
		 * 实现创建缩略图
		 * @param srcFile	源图片地址
		 * @param destFile	目的图片地址
		 * @创建人 PengBo
		 * @创建时间 2013-8-5  上午10:00:17
		 */
		public static void createPreviewImage(String srcFile, String destFile) {   
	        try {   
	            File fi = new File(srcFile); 	//大图片文件  
	            File fo = new File(destFile); 	//将要转换出的小图文件   
	            
	            //读取图片
	            BufferedImage bis = ImageIO.read(fi);   
	            //获得图片原来的高宽
	            int w = bis.getWidth();   
	            int h = bis.getHeight();   
	            
	            //等比例缩放
	            int nw = 120; 	
	            int nh = (nw * h) / w;   
	            if (nh > 120) {   
	                nh = 120;   
	                nw = (nh * w) / h;   
	            }   
	            
	            double sx = (double) nw / w;   
	            double sy = (double) nh / h;   
	            
	            //创建一个转换器
	            AffineTransform transform =new AffineTransform();
	            transform.setToScale(sx, sy);  
	            
	            AffineTransformOp ato = new AffineTransformOp(transform, null);   
	            
	            BufferedImage bid = new BufferedImage(nw, nh,   
	                    BufferedImage.TYPE_3BYTE_BGR);  
	            
	            ato.filter(bis, bid);  
	            
	            ImageIO.write(bid, "jpeg", fo);   
	            
	            
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        }   
	    }
}
