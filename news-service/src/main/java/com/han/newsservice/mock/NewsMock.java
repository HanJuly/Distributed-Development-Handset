package com.han.newsservice.mock;

import com.han.newsservice.pojo.News;
import com.han.newsservice.pojo.ResponseBase;
import com.han.newsservice.service.INewsService;
import com.han.newsservice.util.TempJsonUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewsMock implements INewsService {
    @Override
    public ResponseBase getNewsList() {
        String basePath = this.getClass().getResource("/").getPath();
        List<News> news = TempJsonUtils.listFromFile(String.format("%snews-model.json",basePath),News.class);
        ResponseBase<News> responseBase = new ResponseBase<>();
        responseBase.setData(news);
        return responseBase;
    }
}
