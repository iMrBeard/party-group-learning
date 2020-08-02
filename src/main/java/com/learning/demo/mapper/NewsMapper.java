package com.learning.demo.mapper;

import com.learning.demo.entity.News;

import java.util.List;

public interface NewsMapper {
    int addNews(News news);

    int deleteNews(Integer newsId);

    int updateNews(News news);

    News isExistNews(String newsName);

    List<News> getNews();
}
