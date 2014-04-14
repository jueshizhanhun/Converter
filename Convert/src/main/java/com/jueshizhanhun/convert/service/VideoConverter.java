package com.jueshizhanhun.convert.service;

public interface VideoConverter{

	/**
	 * ffmpeg 视频转码
	 * @param s1
	 * @param s2
	 * @return
	 * @创建人 PengBo
	 * @创建时间 2014-1-6  上午11:11:52
	 */
	  String ffmpegVideoConverter(String s1,String s2);
		/**
		 * mencoder 视频转码
		 * @param s1
		 * @param s2
		 * @return
		 * @创建人 PengBo
		 * @创建时间 2014-1-6  上午11:11:52
		 */
	  String mencoderVideoConverter(String s1,String s2);
		/**
		 * ffmpeg 图片转码
		 * @param s1
		 * @param s2
		 * @return
		 * @创建人 PengBo
		 * @创建时间 2014-1-6  上午11:11:52
		 */
	  String ffmpegImageConverter(String s1,String s2);
}
