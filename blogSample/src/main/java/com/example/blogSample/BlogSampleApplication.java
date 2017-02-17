package com.example.blogSample;

import com.example.blogSample.domain.Comment;
import com.example.blogSample.domain.News;
import com.example.blogSample.service.CommentService;
import com.example.blogSample.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogSampleApplication implements CommandLineRunner{

	@Autowired
	private NewsService newsService;

	@Autowired
	private CommentService commentService;


	public static void main(String[] args) {
		SpringApplication.run(BlogSampleApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

//		News news = new News();
//		newsService.create(news);
//
//		Comment comment = new Comment("Trol", "Heits gona Hejts");
//		commentService.create(comment);

	}
}
