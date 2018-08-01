package com.jyu.base;

public class BaseController {
	
	public static final int RESULT_CODE_SUCCESS = 1001; //操作成功
	public static final int RESULT_CODE_FAIL = 1002; //操作失败
	
	
	/**
	 * 成功结果对象
	 * 
	 * @param msg
	 *            信息
	 * @param content
	 *            内容
	 * @return
	 */
	protected Result SuccessResult(String msg, Object content) {
		return new Result(RESULT_CODE_SUCCESS, msg, content);
	}
	
	/**
	 * 失败结果对象
	 * 
	 * @param msg
	 *            信息
	 * @param content
	 *            内容
	 * @return
	 */
	protected Result FailResult(String msg, Object content) {
		return new Result(RESULT_CODE_FAIL, msg, content);
	}
	
}
