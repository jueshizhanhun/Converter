package com.jueshizhanhun.convert.service.impl;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jueshizhanhun.convert.service.VideoConverter;
import com.jueshizhanhun.convert.utils.PathUtils;

@Service
public class ffmpegConverter implements VideoConverter{

	// 获取配置的转换工具（ffmpeg.exe）的存放路径
//    static String ffmpegPath = PathUtils.getMavenWebProjectPath("\\resource\\tools\\ffmpeg.exe");
    static String ffmpegPath = ("D:\\development\\Conert\\ffmpeg\\bin\\ffmpeg.exe");
	  /**
	   * ffmpeg抓去图片
	   */
	// 生成图片 参数String newfilename, String newimg 
	  public synchronized String ffmpegImageConverter(String videoPath, String newImagePath) { 
	    List<String> commend = new java.util.ArrayList<String>(); 
	    commend.add(ffmpegPath); 
	    commend.add("-i"); 
	    commend.add(videoPath); 
	    commend.add("-y"); 
	    commend.add("-f"); 
	    commend.add("image2"); 
	    commend.add("-ss"); 
	    commend.add("5"); 
	    commend.add("-t"); 
	    commend.add("0.001"); 
	    commend.add("-s"); 
	    commend.add("320x240"); 
	    commend.add(newImagePath); 
	    System.out.println(commend); 
	    try { 
	      ProcessBuilder builder = new ProcessBuilder(); 
	      builder.command(commend); 
	      Process process= builder.start(); 
	      //等待进程执行完毕
          if(process.waitFor() != 0){
                 //如果进程运行结果不为0,表示进程是错误退出的
                 //获得进程实例的错误输出
                 InputStream error = process.getErrorStream();
                 //do something
           //  System.out.println(error.);
          }
	     System.out.println(process.waitFor()); 
	      return newImagePath; 
	    } catch (Exception e) { 
	      e.printStackTrace(); 
	      return null; 
	    } 
	  }


	  /**
	   * ffmpeg视频转换
	   */
	@Override
	public  synchronized String ffmpegVideoConverter(String videoPath, String targetPath) {
//	    if (!checkfile(videoPath)) { 
//	      System.out.println(videoPath + " is not file aaa"); 
//	      return false; 
//	    } 
	    List<String> commend = new java.util.ArrayList<String>(); 
	    commend.add(ffmpegPath);    
	    commend.add("-i"); 
	    commend.add(videoPath); 
	    commend.add("-ab"); 
	    commend.add("64"); 
//	    commend.add(" -acodec "); 
//	    commend.add("codec"); 
	    commend.add("-ac"); 
	    commend.add("2"); 
	    commend.add("-ar"); 
	    commend.add("22050"); 
	    //清晰度    -qscale 4 为最好可是文件大, -qscale 6就可以了 
	    commend.add("-qscale"); 
	    commend.add("6"); 
//	    commend.add("-b"); 
//	    commend.add("768"); 
//	    commend.add("230"); 
//	    commend.add("-s"); 
//	    commend.add("352x240"); 
//	    commend.add("-r"); 
//	    commend.add("29.97"); 
	    commend.add("-y"); 
	    commend.add(targetPath); 
	    System.out.println(commend); 
	    try { 
	      ProcessBuilder builder = new ProcessBuilder(); 
	      builder.command(commend); 
	      Process process= builder.start(); 
	      //等待进程执行完毕
          if(process.waitFor() != 0){
                 //如果进程运行结果不为0,表示进程是错误退出的
                 //获得进程实例的错误输出
                 InputStream error = process.getErrorStream();
                 //do something
           //  System.out.println(error.);
          }
	     System.out.println(process.exitValue()); 
	      return targetPath; 
	    } catch (Exception e) { 
	      e.printStackTrace(); 
	      return null; 
	    } 

	}


	public String Video2segment(String videoPath,String tsPath, String m3u8Path,String httpPath) {
	    List<String> commend = new java.util.ArrayList<String>(); 
	    commend.add("ffmpeg");    
	    commend.add("-loglevel"); 
	    commend.add("quiet");
	    commend.add("-i"); 
	    commend.add(videoPath); 
	    commend.add("-f"); 
	    commend.add("mpegts"); 
	    commend.add("- |"); 
	    commend.add("segmenter"); 
	    commend.add("-i -"); 
	    commend.add("-threads"); 
	    commend.add("5"); 
	    commend.add("-d"); 
	    commend.add("10"); 
	    commend.add("-p"); 
	    commend.add(tsPath);
	    commend.add("-m"); 
	    commend.add(m3u8Path);
	    commend.add("-u"); 
	    commend.add(httpPath); 
	    System.out.println(commend); 
	    try { 
	      ProcessBuilder builder = new ProcessBuilder(); 
	      builder.command(commend); 
	      builder.start(); 
	  	return m3u8Path; 
	    } catch (Exception e) { 
	      e.printStackTrace(); 
	      return null; 
	    }
	}
	
	
	public String Video2TS(String videoPath,String tsPath,String segmentPath,String m3u8Path,String httpPath) {
	    List<String> commend = new java.util.ArrayList<String>(); 
	    commend.add("ffmpeg");    
	    commend.add("-i"); 
	    commend.add(videoPath); 
	    commend.add("-threads");
	    commend.add("10");
	    commend.add("-vcodec");
	    commend.add("libx264");
	    commend.add("-y"); 
	    commend.add(tsPath);
	    System.out.println(commend); 
	    try { 
	      ProcessBuilder builder = new ProcessBuilder(); 
	      builder.command(commend); 
	      Process p = builder.start(); 
	      if (p.exitValue() != 0) {
	    	  throw new Exception();
		} 
	      return TS2M3u8(tsPath,segmentPath,m3u8Path,httpPath);
	    } catch (Exception e) { 
	      e.printStackTrace(); 
	      return null; 
	    }
	}
	
	public String TS2M3u8(String videoPath,String tsPath, String m3u8Path,String httpPath) {
	    List<String> commend = new java.util.ArrayList<String>(); 
	    commend.add("segmenter");    
	    commend.add("-i"); 
	    commend.add(videoPath); 
	    commend.add("-d");
	    commend.add("10");
	    commend.add("-p");
	    commend.add(tsPath);
	    commend.add("-m"); 
	    commend.add(m3u8Path);
	    commend.add("-u"); 
	    commend.add(httpPath);
	    System.out.println(commend); 
	    try { 
	      ProcessBuilder builder = new ProcessBuilder(); 
	      builder.command(commend); 
	      Process p = builder.start(); 
	      if (p.exitValue() != 0) {
	    	   throw new Exception();
	      } 
	      return m3u8Path;
	    } catch (Exception e) { 
	      e.printStackTrace(); 
	      return null; 
	    }
	}
	
	
	
	/**
	 * mencoder视频转换
	 */
	@Override
	public String mencoderVideoConverter(String videoPath, String targetPath) {

	    List<String> commend = new java.util.ArrayList<String>(); 
	    commend.add("d:\\flv\\MediaCoder\\codecs\\mencoder.exe");    
	    commend.add(videoPath); 
	    //音频采用mp3编码 
	    commend.add("-oac"); 
	    commend.add("mp3lame"); 
	    //采用高质DivX视频编码，视频码率为112kbps 
	    commend.add("-ovc"); 
	    commend.add("lavc"); 
	    commend.add("-lavcopts"); 
	    commend.add("vcodec=flv:vbitrate=500:mbd=2:mv0:trell:v4mv:cbp:last_pred=3:dia=-1:cmp=3:vb_strategy=1"); 
	    commend.add("-lameopts"); 
	    commend.add("abr:br=56"); 
	    //声音采样频率设置，现为22K    
	    commend.add("-srate"); 
	    commend.add("22050"); 
	    //-sws就是用来设置品质的，默认值为2 
	    commend.add("-sws"); 
	    commend.add("3"); 
	    //宽度为208，高度自动调整保持比例； 
	    //-vf scale=-3:176宽度自动调整保持比例，高度为176；如果想保持原来的大小可以不要这个参数    
	    commend.add("-vf"); 
	    commend.add("scale=512:-3"); 
	    // 帧速率设置 
	    commend.add("-ofps"); 
	    commend.add("18"); 
	    /* 
	     * mode=3:cbr:br=24单声道 
	     * 音频码率为24kbps;-lameopts mode=0:cbr:br=24立体声，音频码率为24kbps;    
	     * 还可设置音量，-lameopts mode=3:cbr:br=32:vol=1，设置范置为1~10，但不宜设得太高 
	     */ 
	    commend.add("-lameopts"); 
	    commend.add("vbr=3:br=128"); 
	    commend.add("-o"); 
	    commend.add(targetPath); 
	    //控制台显示执行的命令 
	    //System.out.println(commend); 
	    try { 
	      ProcessBuilder builder = new ProcessBuilder(); 
	      builder.command(commend); 
	      builder.start(); 
	      return targetPath; 
	    } catch (Exception e) { 
	      e.printStackTrace(); 
	      return null; 
	    } 
	    
	}
	
	
	public String getTime( String videoPath){
	      File source = new File(videoPath);
	        Encoder encoder = new Encoder();
	        try {
	             MultimediaInfo m = encoder.getInfo(source);
	             Long ls = m.getDuration();
	             
	             Long l = ls/1000;
	             Long hLong = l/3600;
	             Long mLong = (l-hLong*3600)/60;
	             Long sLong = (l-hLong*3600-mLong*60);
	             Long hs=ls-l*1000;
	             System.out.println("此视频时长为:"+hLong+"时"+mLong+"分"+sLong+"秒"+hs+"毫秒！");
	             System.out.println("此视频时总长为:"+ls+"毫秒！");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			return videoPath;
	}
	
	public void getfile(){
		File file = new File("D:\\streams\\jjyy\\");
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			System.out.println(i);
			 System.out.println("第"+i+"个");
		     System.out.println(files[i]);
		     System.out.println(path(files[i].toString())+".flv");
		}

	}
	
	public String path(String url){
		int splitIndex = url.lastIndexOf(".");
		return url.substring(0, splitIndex);
	}

	  public static void main(String[] args) {
		 String videoPath ="D:\\streams\\jjyy\\PH传感器的标定.asf";
		 String newImagePath ="D:\\streams\\jjyy\\PH传感器的标定.flv";
		 ffmpegConverter fConverter =new ffmpegConverter();
//		 fConverter.ffmpegVideoConverter(videoPath, newImagePath);
//		 fConverter.ffmpegVideoConverter(newImagePath,videoPath);
//		 fConverter.ffmpegImageConverter(videoPath, newImagePath);
//		 fConverter.Video2TS(videoPath, "2", "3", "4", "5");
//		 fConverter.ffmpegVideoConverter(videoPath,newImagePath);
		 fConverter.getfile();
	}
	  
}
