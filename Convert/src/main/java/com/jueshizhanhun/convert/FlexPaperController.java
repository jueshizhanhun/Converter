package com.jueshizhanhun.convert;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jueshizhanhun.convert.service.PDFConverter;
import com.jueshizhanhun.convert.service.SWFConverter;
import com.jueshizhanhun.convert.service.impl.OpenOfficePDFConverter;
import com.jueshizhanhun.convert.service.impl.SWFToolsSWFConverter;
import com.jueshizhanhun.convert.utils.DocConverterUtils;
import com.jueshizhanhun.convert.utils.PathUtils;


@Controller
@RequestMapping("/flex")
public class FlexPaperController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String page(){
		return "docPlayer/flexPaper";
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public String upload(){
		return "docPlayer/flexUpload";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView getFlex(@RequestParam("fileUpload") CommonsMultipartFile file){
		 // 获取文件类型  
        System.out.println(file.getContentType());  
        // 获取文件大小  
        System.out.println(file.getSize());  
        // 获取文件名称  
        System.out.println(file.getOriginalFilename());  
  
        String path = "\\resources\\docs\\";
        path = PathUtils.getPath(path);
        // 判断文件是否存在  
        if (!file.isEmpty()) {  
            path =  path + file.getOriginalFilename();  
            File localFile = new File(path);  
            try {  
            	
                file.transferTo(localFile);  
                
        		PDFConverter pdfConverter = new OpenOfficePDFConverter();
        		SWFConverter swfConverter = new SWFToolsSWFConverter();
        		DocConverterUtils converter = new DocConverterUtils(pdfConverter,swfConverter);
        		converter.convert(path);
        		
        		path = path.substring(0, path.lastIndexOf("."));
        		path = path+".swf";
        		
            } catch (IllegalStateException e) {  
                e.printStackTrace();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        
        return new ModelAndView("docPlayer/flexpaper").addObject("file", path);  
    }  
	
}
