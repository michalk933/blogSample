package com.example.blogSample.rest;


import com.example.blogSample.domain.Comment;
import com.example.blogSample.domain.News;
import com.example.blogSample.service.CommentService;
import com.example.blogSample.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/news")
public class AppRestControler {

    private final CommentService commentService;
    private final NewsService newsService;

    @Autowired
    public AppRestControler(CommentService commentService, NewsService newsService) {
        this.commentService = commentService;
        this.newsService = newsService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getNews")
    public List<News> findAllNews(){
        return newsService.getObj();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getComment")
    public @ResponseBody List<Comment> findAddComment(){
        return commentService.getObj();
    }


    // to będzie do zmiany raczej jeszcze nie wiem jak będzie działać
    @RequestMapping(method = RequestMethod.POST, value = "/saveNews")
    public @ResponseBody Map<String, Object> create(@Valid @RequestBody News newsEnity, BindingResult bindingResult){
        Map<String, Object> respons = new LinkedHashMap<>();

        if(bindingResult.hasErrors()){
            List<FieldError> errors = bindingResult.getFieldErrors();
            respons.put("Massage", "Error");

            for (FieldError error : errors) {
                System.out.println(error.getField() + "  " + error.getDefaultMessage() + " ======= ! ======");
                respons.put(error.getField(), error.getDefaultMessage());
            }
        }else {
            System.out.println(" ======= ! ======");
            respons.put("Massage", "News created sucessfully");
            newsService.create(newsEnity);

        }

        respons.put("Massage", "bla bla");
        return respons;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveComment")
    public @ResponseBody
    Object create(@RequestBody Comment commentEntity){
        return commentService.create(commentEntity);
    }



}
