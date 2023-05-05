package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController3 {

	
	@RequestMapping("/hello3")
	public String handl() {
		return "hello3, springboot 3 你好";
	}
}

/*
	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@Controller
	@ResponseBody
	public @interface RestController {
*/

