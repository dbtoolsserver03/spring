package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtherPackageController {

	
	@RequestMapping("/othercontrol")
	public String handl() {
		return "hello, springboot 3 othercontrol";
	}
}