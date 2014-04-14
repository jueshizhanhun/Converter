package com.jueshizhanhun.convert.utils;

import com.jueshizhanhun.convert.service.PDFConverter;
import com.jueshizhanhun.convert.service.SWFConverter;

public class DocConverterUtils {

	private PDFConverter pdfConverter;
	private SWFConverter swfConverter;
	
	
	public DocConverterUtils(PDFConverter pdfConverter, SWFConverter swfConverter) {
		super();
		this.pdfConverter = pdfConverter;
		this.swfConverter = swfConverter;
	}


	public  void convert(String inputFile,String swfFile){
		this.pdfConverter.convert2PDF(inputFile);
		String pdfFile = FileUtils.getFilePrefix(inputFile)+".pdf";
		this.swfConverter.convert2SWF(pdfFile, swfFile);
	}
	
	public void convert(String inputFile){
		this.pdfConverter.convert2PDF(inputFile);
		String pdfFile = FileUtils.getFilePrefix(inputFile)+".pdf";
		this.swfConverter.convert2SWF(pdfFile);
		
	}
	
}
