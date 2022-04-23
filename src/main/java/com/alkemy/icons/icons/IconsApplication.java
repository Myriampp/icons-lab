package com.alkemy.icons.icons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.alkemy.icons.iconsApplication" )

//@ComponentScan(basePackages = {"com.alkemy.icons.IconsApplication"})
public class IconsApplication {

	public static void main(String[] args) {
		SpringApplication.run(IconsApplication.class, args);
	}

}
