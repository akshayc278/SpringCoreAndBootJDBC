package com.tech.tab;

import java.sql.Connection;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.tech.tab.model.Student;

@Configuration
public class ConfigurationOne {
	private static String className="configurationOne";
	
	@Bean
	public String getClassName() {
		return className;
	}
	

	@Bean
	public String getClassName1() {
		return className+"hi";
	}
	
	@Bean
	public  List<Student> getStudent(){
		List<Student> listOfStudents=new LinkedList<>();
		Student s1=new Student(1,"akshay");
		Student s2=new Student(2,"kshitija");
		Student s3=new Student(3,"vikas");
		Student s4=new Student(4,"four");
		listOfStudents.add(s1);listOfStudents.add(s2);listOfStudents.add(s3);listOfStudents.add(s4);
		return listOfStudents;
		
	}
	
	
	
	
}
