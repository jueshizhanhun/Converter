package com.jueshizhanhun.convert.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jueshizhanhun.convert.service.VideoConverter;
import com.jueshizhanhun.convert.utils.PathUtils;

@Service
public class ffmpegConverter implements VideoConverter{

	// 获取配置的转换工具（ffmpeg.exe）的存放路径
    static String ffmpegPath = PathUtils.getMavenWebProjectPath("\\resource\\tools\\ffmpeg.exe");

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
	    commend.add("38"); 
	    commend.add("-t"); 
	    commend.add("0.001"); 
	    commend.add("-s"); 
	    commend.add("320x240"); 
	    commend.add(newImagePath); 
	    try { 
	      ProcessBuilder builder = new ProcessBuilder(); 
	      builder.command(commend); 
	      builder.start(); 
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
	public String ffmpegVideoConverter(String videoPath, String targetPath) {
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
	      builder.start(); 
	      return targetPath; 
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

	  
	  
}
