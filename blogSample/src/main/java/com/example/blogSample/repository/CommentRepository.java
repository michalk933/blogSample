package com.example.blogSample.repository;

import com.example.blogSample.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class CommentRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Map<String, Object> getOneComment(){
        String sql = "SELECT * FROM Comment WHERE id_Comment = 1";
        return jdbcTemplate.queryForMap(sql);
    }

    public List<Comment> getAllRecordComment(){
        String sql = "SELECT * FROM Comment";
        RowMapper<Comment> rowMapper = new RowMapper<Comment>() {
            @Override
            public Comment mapRow(ResultSet resultSet, int i) throws SQLException {
                Comment comment = new Comment();
                comment.setId(resultSet.getLong("id_Comment"));
                comment.setTitle(resultSet.getString("title_Comment"));
                comment.setText(resultSet.getString("text_Comment"));
                comment.setData(new Date().toString());
                return comment;
            }
        };
        return jdbcTemplate.query(sql, rowMapper);
    }

    public String addNewComment(Object c){
        Comment comment = (Comment) c;
        String sql = "INSERT INTO Comment (title_Comment,text_Comment) values (?,?)";
        Object[] objects = new Object[]{comment.getTitle(), comment.getText()};
        int updata = jdbcTemplate.update(sql,objects);
        return updata == 1 ? "Dodano nowy rekord" : "Nie dodano nowego rekordu";
    }


    public List<Map<String, Object>> findByNewsId(long id){
        String sql = "SELECT * FROM Comment WHERE id_Comment = ?";
        List<Map<String, Object>> commentList = jdbcTemplate.queryForList(sql, id);
        return commentList;
    }



}
