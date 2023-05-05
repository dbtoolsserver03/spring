package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody // 声明此类下的所有方法返回值直接传给浏览器，非页面资源路径
@Controller
public class HelloController2 {

	@RequestMapping("/hello2")
	public String handle01() {
		return "Hello2, Spring Boot 3! 你好";
	}
}