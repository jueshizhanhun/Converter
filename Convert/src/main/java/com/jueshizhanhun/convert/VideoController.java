package com.jueshizhanhun.convert;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jueshizhanhun.convert.service.VideoConverter;
import com.jueshizhanhun.convert.utils.PathUtils;
import com.jueshizhanhun.convert.utils.VideoConverterUtils;


@Controller
@RequestMapping("/video")
public class VideoController {
	
	@Autowired
	private VideoConverter videoConverter;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String page(){
		return "videoPlayer/videoPlayer";
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public String upload(){
		return "videoPlayer/videoUpload";
	}
	
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView getFlex(@RequestParam("fileUpload") CommonsMultipartFile file){
		 // 获取文件类型  
        System.out.println(file.getContentType());  
        // 获取文件大小  
        System.out.println(file.getSize());  
        // 获取文件名称  
        System.out.println(file.getOriginalFilename());  
  
        String path = "\\resources\\videos\\";
        String videoPath = PathUtils.getPath(path);
        String newImagePath = "\\resources\\imgages\\";
        String targetPath = "";
        String fileName = file.getOriginalFilename();
        // 判断文件是否存在  
        if (!file.isEmpty()) {  
        	videoPath =  videoPath + fileName;  
        
            File localFile = new File(videoPath);  
            try {  
                file.transferTo(localFile);  
        	    int type = VideoConverterUtils.checkContentType(videoPath);
        	    targetPath =videoPath;
        		if (type != 2) {
					targetPath = targetPath.substring(0, path.lastIndexOf("."));
            	    targetPath = targetPath+".flv";
            	    fileName = fileName.substring(0, path.lastIndexOf("."));
            	    fileName = fileName+".flv";
	        		if (type == 0) { 
	        	    	targetPath = videoConverter.ffmpegVideoConverter(videoPath, targetPath); 
	        	    		videoConverter.ffmpegImageConverter(videoPath,newImagePath); 
	        	    } else if (type == 1) { 
	        	    	targetPath =  videoConverter.mencoderVideoConverter(videoPath,targetPath); 
	        	    }
				}
        	    
            } catch (IllegalStateException e) {  
                e.printStackTrace();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        
        return new ModelAndView("videoPlayer/videoPlayer").addObject("file", fileName);  
    }  
	
	
}
