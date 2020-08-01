package com.learning.demo.controller;

import com.learning.demo.entity.Department;
import com.learning.demo.entity.News;
import com.learning.demo.entity.Result;
import com.learning.demo.service.DepartmentService;
import com.learning.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    NewsService newsService;

    @GetMapping(value = "/getNews", produces = "application/json")
    List<News> getNews() {
        return newsService.getNews();
    }

    @PostMapping(value = "/addNews")
    Result addNews(@RequestBody News news) {
        return newsService.addNews(news);
    }

    @PutMapping(value = "/updateNews")
    Result updateNews(@RequestBody News news) {
        return newsService.updateNews(news);
    }

    @DeleteMapping(value = "/deleteNews")
    Result deleteNews(int newsId) {
        return newsService.deleteNews(newsId);
    }
}


