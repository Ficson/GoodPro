package com.jyu.controller;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jyu.base.Result;
import com.jyu.base.BaseController;
import com.jyu.bean.User;
import com.jyu.service.UserService;

@RestController
@RequestMapping("/system")
public class SystemController extends BaseController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private RedisTemplate redisTemplate;

	//登陆
	@RequestMapping("/login")
	@ResponseBody
	public Result login(@RequestBody User user) {
		System.out.println(user.getName() + "--" + user.getPwd());
		String name = user.getName();
		User loginUser = userService.selectByName(name);
		if (loginUser != null) {
			if (loginUser.getPwd().equals(user.getPwd())) {
				ValueOperations valueOperations = redisTemplate.opsForValue();
				System.out.println(valueOperations + "-------");
				String userid = loginUser.getId().toString();
				valueOperations.set(userid,userid, 60* 60 *1000, TimeUnit.SECONDS);
				return SuccessResult("查找成功", loginUser);
			} else {
				return FailResult("密码错误", null);
			}
		}
		return FailResult("用户不存在", null);

	}

	// 用户界面
	@RequestMapping("/select")
	public Result select(@RequestBody Map map) {
		String id = (String) map.get("id");
		User user = userService.selectById(id);
		System.out.println(user.getName() + "--" + user.getId());
		return SuccessResult("操作成功", user);
	}

	// 修改
	@RequestMapping("/update")
	public Result select(@RequestBody User user) {
		int result = userService.update(user);
		if (result == 1) {
			return SuccessResult("更新成功", user);
		} else {
			return FailResult("更新失败", null);
		}

	}
}
