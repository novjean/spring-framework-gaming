package com.novatech.learnspringframework.prepostannotations;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
	private SomeDependency someDependency;
	
	public SomeClass(SomeDependency someDependency){
		super();
		this.someDependency = someDependency;
		System.out.println("all dependencies are ready");
	}
	
	@PostConstruct
	public void initialize() {
		someDependency.getReady();
		
	}
	
	@PreDestroy
	public void cleanup() {
		System.out.println("cleanup");
	}
	
}

class SomeDependency{

	public void getReady() {
		System.out.println("some logic using dependency");
		
	}
	
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {
	
	public static void main(String[] args) {
		//try with resource block
		try(var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
		
	}

}




