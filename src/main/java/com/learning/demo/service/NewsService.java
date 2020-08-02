package com.learning.demo.service;

import com.learning.demo.entity.News;
import com.learning.demo.entity.Result;

import java.util.List;

public interface NewsService {
    List<News> getNews();

    Result updateNews(News news);

    Result addNews(News news);

    Result deleteNews(Integer newsName);
}
