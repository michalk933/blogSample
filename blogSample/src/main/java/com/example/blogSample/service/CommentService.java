package com.example.blogSample.service;

import com.example.blogSample.domain.Comment;
import com.example.blogSample.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommentService implements ServiceInterface, castomInterfaceComment {

    //////////// create new interface finfByComent(id) and implement this class

    private CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List getObj() {
        List<Comment> commentlist = commentRepository.getAllRecordComment();
        return commentlist;
    }

    @Override
    public Object create(Object obj) {
        return commentRepository.addNewComment(obj);
    }

    @Override
    public Object findById(String id) {
        return null;
    }

    @Override
    public Object update(Object obj) {
        return null;
    }


    @Override
    public Comment findByNewsId(long id) {
        List<Map<String, Object>> commentsList = commentRepository.findByNewsId(id);
        return (Comment) commentsList;
    }
}
