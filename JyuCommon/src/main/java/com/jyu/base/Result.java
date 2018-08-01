package com.jyu.base;

public class Result {
	private int code;
	private String msg;
	private Object content;
	
	public Result(int code, String msg) {

		this.code = code;
		this.msg = msg;
	}

	public Result(int code, String msg, Object content) {

		this.code = code;
		this.msg = msg;
		this.content = content;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
	
	
}
