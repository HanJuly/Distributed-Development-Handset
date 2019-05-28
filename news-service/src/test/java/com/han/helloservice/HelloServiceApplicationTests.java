package com.han.helloservice;

import com.han.newsservice.pojo.News;
//import com.han.newsservice.util.TempJsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class HelloServiceApplicationTests {

	@Test
	public void contextLoads() {
        String basePath = this.getClass().getResource("/").getPath();
//		List<News> news = TempJsonUtils.listFromFile("D:\\Recursion\\project\\SpringCloudDemo\\news-service\\src\\main\\resources\\news-model.json", News.class);
		System.out.println(basePath);
	}

}
