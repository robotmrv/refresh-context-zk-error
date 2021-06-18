package com.example.zkerror;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigurationProperties(Props.class)
public class ZkErrorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZkErrorApplication.class, args);
	}

}

@ConfigurationProperties("test")
@ConstructorBinding
class Props {
	private String prop1;

	public Props(String prop1) {
		this.prop1 = prop1;
	}

	public String getProp1() {
		return prop1;
	}

//	public void setProp1(String prop1) {
//		this.prop1 = prop1;
//	}
}

@RestController
class Ctrl {
	@Autowired
	Props props;

	@GetMapping("test")
	public String test() {
		return props.getProp1();
	}
}
