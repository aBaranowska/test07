package com.rec.spring;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class ExampleServiceTest {

	private static final String HELLO_WORLD = "Hello world!";

	private ApplicationContext context;

	@Before
	public void setUp() {
		context = new AnnotationConfigApplicationContext(AppConfig.class);
	}

	@After
	public void tearDown() {
		((AbstractApplicationContext) context).close();
	}

	@Test
	public void getBean01() {
		Service bean = context.getBean(Service.class);
		assertEquals(HELLO_WORLD, bean.getMessage());
	}

	@Test(expected = NoSuchBeanDefinitionException.class)
	public void getBean02() {
		context.getBean("exampleServiceBean", Service.class);
	}

	@Test
	public void getBean03() {
		Service bean = context.getBean("theExampleService", Service.class);
		assertEquals(HELLO_WORLD, bean.getMessage());
	}

	@Test
	public void getBean04() {
		Service bean = context.getBean("exampleServiceAlias", Service.class);
		assertEquals(HELLO_WORLD, bean.getMessage());
	}

}
