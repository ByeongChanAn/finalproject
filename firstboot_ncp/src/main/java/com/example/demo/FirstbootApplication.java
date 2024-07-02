package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import spring.mybatis.board.BoardController;

/*1. 내장 tomcat 시작(8080->9090), 
 * 2. component-scan 자동 동작 설정, 
 3. src/main/respources/application.properties
 //  /WEB-INF/views/*.jsp 경로와 확장자 사용자추가설정
 
 
//스프링부트클래스 실행 - run as - spring boot app (선택!!!!) / java application (main) / run on server(mvc, jsp, servlet)
*/
@SpringBootApplication //실행
//@ComponentScan  
//@ComponentScan(basePackages = "upload")
//@ComponentScan(basePackageClasses = BoardController.class)

//@ComponentScan(basePackages = {"upload", "spring.mybatis.board"})

@ComponentScan(basePackages = "boardmapper")
@MapperScan(basePackages = "boardmapper")
@ComponentScan(basePackages = "websocket")
public class FirstbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstbootApplication.class, args);
	}

}
