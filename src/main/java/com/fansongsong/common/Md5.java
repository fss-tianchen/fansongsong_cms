package com.fansongsong.common;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
 * @ClassName: Md5 
 * @Description: 加密工具类
 * @author: Creazy丿绝情
 * @date: 2019年11月21日 上午9:09:32
 */
public class Md5 {

	public static String password(String password, String salt) {
		// TODO Auto-generated method stub
		return DigestUtils.md5Hex(password + "::::" +  salt);
	}
}
