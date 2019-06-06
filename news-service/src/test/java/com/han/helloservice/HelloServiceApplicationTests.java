package com.han.helloservice;

import com.han.newsservice.pojo.News;
//import com.han.newsservice.util.TempJsonUtils;
import com.han.newsservice.util.TempJsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class HelloServiceApplicationTests {

	@Test
	public void contextLoads() {
		InputStream inputStream = this.getClass().getResourceAsStream("/news-model.json");
	}

}
