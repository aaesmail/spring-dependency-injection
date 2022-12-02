package com.example.dependencyinjection;

import com.example.dependencyinjection.config.DiConfiguration;
import com.example.dependencyinjection.config.DiConstructorConfig;
import com.example.dependencyinjection.controllers.ConstructorInjectedController;
import com.example.dependencyinjection.controllers.I18nController;
import com.example.dependencyinjection.controllers.MyController;
import com.example.dependencyinjection.controllers.PropertyInjectedController;
import com.example.dependencyinjection.controllers.SetterInjectedController;
import com.example.dependencyinjection.datasource.FakeDataSource;
import com.example.dependencyinjection.services.PrototypeBean;
import com.example.dependencyinjection.services.SingeltonBean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "com.example.dependencyinjection" })
@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DependencyInjectionApplication.class, args);

		System.out.println("\n\n---------- Profile");
		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		MyController myController = (MyController) ctx.getBean("myController");

		System.out.println("\n---------- Primary Bean");
		System.out.println(myController.sayHello());

		System.out.println("\n---------- Property");

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx
				.getBean("propertyInjectedController");

		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("\n---------- Setter");

		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx
				.getBean("setterInjectedController");

		System.out.println(setterInjectedController.getGreeting());

		System.out.println("\n---------- Contructor");

		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx
				.getBean("constructorInjectedController");

		System.out.println(constructorInjectedController.getGreeting());

		System.out.println("\n---------- Bean Scopes");
		SingeltonBean singeltonBean1 = ctx.getBean(SingeltonBean.class);
		System.out.println(singeltonBean1.getMyScope());
		SingeltonBean singeltonBean2 = ctx.getBean(SingeltonBean.class);
		System.out.println(singeltonBean2.getMyScope());

		PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getMyScope());
		PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.getMyScope());

		System.out.println("\n---------- External Properties");
		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcurl());

		System.out.println("\n---------- Config Properties Bean");
		DiConfiguration diConfiguration = ctx.getBean(DiConfiguration.class);
		System.out.println(diConfiguration.getUsername());
		System.out.println(diConfiguration.getPassword());
		System.out.println(diConfiguration.getJdbcurl());

		System.out.println("\n---------- Constructor Binding Bean");
		DiConstructorConfig diConstructorConfig = ctx.getBean(DiConstructorConfig.class);
		System.out.println(diConstructorConfig.getUsername());
		System.out.println(diConstructorConfig.getPassword());
		System.out.println(diConstructorConfig.getJdbcurl());

		System.out.println("\n");
	}

}
