package com.fansongsong.common;

import java.io.Serializable;

/**
 * 
 * @ClassName: MsgResult 
 * @Description: 用于前后端交互的协议
 * @author: Creazy丿绝情
 * @date: 2019年11月21日 上午9:10:11
 */
public class MsgResult implements Serializable {
	
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -3270650550789341492L;
	
	int result;
	String errorMsg;
	Object data;
	
	public MsgResult() {
		
	}
	
	public MsgResult(int result, String errorMsg, Object data) {
		super();
		this.result = result;
		this.errorMsg = errorMsg;
		this.data = data;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	
	
}
