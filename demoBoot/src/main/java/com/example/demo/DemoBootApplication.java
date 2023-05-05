package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.bean.Pet;
import com.example.demo.bean.User;
import com.example.demo.config.MyConfigProxyFalse;
import com.example.demo.config.MyConfigProxyTrue;

@SpringBootApplication(scanBasePackages = { "com.example" })

//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan({"com.example"})
public class DemoBootApplication {

	public static void main(String[] args) {
		//1、返回我们IOC容器
		ConfigurableApplicationContext run = SpringApplication.run(DemoBootApplication.class, args);

		//2、查看容器里面的组件
		String[] names = run.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}

		//如果@Configuration(proxyBeanMethods = false)
		System.out.println("以下是MyConfigProxyFalse的多实例场合-------------------------------------");
		User userFalse01 = run.getBean("userFalse001", User.class);
		User userFalse02 = run.getBean("userFalse001", User.class);
		System.out.println("组件 User：" + (userFalse01 == userFalse02));//true
		System.out.println("组件 Pet：" + (userFalse01.getPet() == userFalse02.getPet()));//true/false

		Pet tomFalse01 = run.getBean("tomFalse001", Pet.class);
		Pet tomFalse02 = run.getBean("tomFalse001", Pet.class);
		System.out.println("组件 Pet：" + (tomFalse01 == tomFalse02));//true/false

		MyConfigProxyFalse configyFalseBean = run.getBean(MyConfigProxyFalse.class);
		System.out.println(configyFalseBean);

		//如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。
		//保持组件单实例
		User configyFalseBeanUser01 = configyFalseBean.userFalse001();
		User configyFalseBeanUser02 = configyFalseBean.userFalse001();
		System.out.println("用户：" + (configyFalseBeanUser01 == configyFalseBeanUser02));
		System.out.println("用户的宠物：" + (configyFalseBeanUser01.getPet() == configyFalseBeanUser02.getPet()));

		//如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。
		//保持组件单实例/多实例

		//如果@Configuration(proxyBeanMethods = True)
		System.out.println("以下是MyConfigProxyTrue的单实例场合-------------------------------------");
		User userTrue01 = run.getBean("userTrue001", User.class);
		User userTrue02 = run.getBean("userTrue001", User.class);
		System.out.println("组件 User：" + (userTrue01 == userTrue02));//true
		System.out.println("组件 Pet：" + (userTrue01.getPet() == userTrue02.getPet()));//true/True

		Pet tomTrue01 = run.getBean("tomTrue001", Pet.class);
		Pet tomTrue02 = run.getBean("tomTrue001", Pet.class);
		System.out.println("组件 Pet：" + (tomTrue01 == tomTrue02));//true/True

		MyConfigProxyTrue configyTrueBean = run.getBean(MyConfigProxyTrue.class);
		System.out.println(configyTrueBean);

		//如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。
		//保持组件单实例
		User configyTrueBeanUser01 = configyTrueBean.userTrue001();
		User configyTrueBeanUser02 = configyTrueBean.userTrue001();
		System.out.println("用户：" + (configyTrueBeanUser01 == configyTrueBeanUser02));
		System.out.println("用户的宠物：" + (configyTrueBeanUser01.getPet() == configyTrueBeanUser02.getPet()));

		
		

	}

}
