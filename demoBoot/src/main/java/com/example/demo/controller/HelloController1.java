package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController1 {

	@ResponseBody // 声明方法返回值直接传给浏览器，非页面资源路径
	@RequestMapping("/hello1")
	public String handle01() {
		return "Hello1, Spring Boot 3! 你好";
	}
}
