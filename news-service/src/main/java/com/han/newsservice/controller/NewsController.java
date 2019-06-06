package com.han.newsservice.controller;

import com.han.newsservice.pojo.News;
import com.han.newsservice.pojo.ResponseBase;
import com.han.newsservice.service.INewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    private static final Logger NEWS_LOGGER = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    INewsService newsService;

    @ResponseBody
    @GetMapping("/list")
    public ResponseBase list(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
        return newsService.getNewsList();
    }


}
