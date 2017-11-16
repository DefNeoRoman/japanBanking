package com;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import service.JpyService;



//http://cbr.ru/scripts/XML_daily.asp
//это отсюда запрашиваем японскую йену
@SpringBootApplication
@ComponentScan(basePackages = {
		"web","service","repository","com"},
		basePackageClasses = Application.class)
@EntityScan("model")
@EnableJpaRepositories("repository")
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);


		context.getBean(JpyService.class).fillRepository();
		System.out.println(context.getBean(JpyService.class).getAll());

	}



}