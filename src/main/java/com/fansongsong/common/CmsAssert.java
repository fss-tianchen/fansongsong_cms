package com.fansongsong.common;

public class CmsAssert {
	
	public static void AssertTrue(boolean express,String msg){
		if(!express)
			throw new CmcException(msg);
	}
	
	/**
	 * 
	 * @Title: AssertTrueHtml 
	 * @Description: TODO
	 * @param express
	 * @param msg
	 * @return: void
	 */
	public static void AssertTrueHtml(boolean express, String msg) {
		// TODO Auto-generated method stub
		if(!express)
			throw new CmcExceptionHtml(msg);
	}

}
