package com.jyu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	private Log log = LogFactory.getLog(this.getClass());
	private RedisTemplate<String, Object> redisTemplate;
	
	public LoginInterceptor(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		response.setContentType("application/json; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("-进入拦截器");
		String auth = request.getHeader("token");
		if(auth == null || auth.equals("")) {
			return false;
		}else {
			//获取redis的值
			Object obj = redisTemplate.boundValueOps(auth).get();
			if(obj != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
