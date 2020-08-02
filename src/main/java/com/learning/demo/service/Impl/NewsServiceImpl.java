package com.learning.demo.service.Impl;

import com.learning.demo.entity.News;
import com.learning.demo.entity.Result;
import com.learning.demo.mapper.NewsMapper;
import com.learning.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> getNews() {
        return newsMapper.getNews();
    }

    @Override
    public Result updateNews(News news) {
        return null;
    }

    @Override
    public Result addNews(News news) {

        if (newsMapper.isExistNews(news.getNewsName()) != null) {
            return Result.ofFail("新闻已经存在！");
        }
        news.setNewsDate(LocalDateTime.now());
        if (newsMapper.addNews(news) == 1) {

            return Result.ofSuccess("新闻添加成功！");
        } else
            return Result.ofFail("新闻添加失败");
    }


    @Override
    public Result deleteNews(Integer newsId) {

        if (newsMapper.deleteNews(newsId) == 1)
            return Result.ofSuccess("删除新闻成功！");
        else
            return Result.ofFail("删除新闻失败！");
    }
}
