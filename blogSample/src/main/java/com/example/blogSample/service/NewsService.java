package com.example.blogSample.service;


import com.example.blogSample.domain.News;
import com.example.blogSample.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService implements ServiceInterface {

    private NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List getObj() {
        List<News> newsList = newsRepository.getAllRecordNews();
        return newsList;
    }

    @Override
    public Object create(Object obj) {
        return newsRepository.addNewNews(obj);
    }

    @Override
    public Object findById(String id) {
        return null;
    }

    @Override
    public Object update(Object obj) {
        return null;
    }
}
