package com.jueshizhanhun.convert.service;

/**
 * 转换pdf工厂
 * @创建人 PengBo
 * @创建时间 2014-1-3  下午5:39:15
 */
public interface PDFConverter {
	public void convert2PDF(String inputFile,String pdfFile);
	public void convert2PDF(String inputFile);

}
