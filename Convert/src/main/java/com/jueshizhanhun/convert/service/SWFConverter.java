package com.jueshizhanhun.convert.service;

/**
 * 转换SWF工厂
 * @创建人 PengBo
 * @创建时间 2014-1-3  下午5:39:37
 */
public interface SWFConverter {
	public void convert2SWF(String inputFile,String swfFile);
	public void convert2SWF(String inputFile);
}
