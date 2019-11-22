package com.fansongsong.common;

/**
 * 
 * @ClassName: CmsExceptionHtml 
 * @Description: 抛出异常，异常在页面显示
 * @author: Creazy丿绝情
 * @date: 2019年11月19日 下午2:18:38
 */
public class CmcExceptionHtml extends RuntimeException {
	
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -6762629250308786819L;

	public CmcExceptionHtml(String msg) {
		super(msg);
	}

}
