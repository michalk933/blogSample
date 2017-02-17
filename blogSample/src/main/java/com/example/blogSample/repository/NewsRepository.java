package com.example.blogSample.repository;

import com.example.blogSample.domain.News;
import com.mysql.fabric.xmlrpc.base.Data;
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
public class NewsRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate((javax.sql.DataSource) dataSource);
    }

    public Map<String, Object> getOneRecordWithId(){
        String sql ="select * from News where id_news = 1";
        return jdbcTemplate.queryForMap(sql);
    }

    public List<News> getAllRecordNews(){
        String sql = "SELECT * FROM News";
        RowMapper<News> rowMapper = new RowMapper<News>() {
            @Override
            public News mapRow(ResultSet resultSet, int i) throws SQLException {
                News news = new News();
                news.setId(resultSet.getLong("id_news"));
                news.setTitle(resultSet.getString("title_news"));
                news.setText(resultSet.getString("text_nest"));
                news.setAuthor(resultSet.getString("author"));
                news.setData((new Date().toString()));
                return news;
            }
        };
        return jdbcTemplate.query(sql, rowMapper);
    }

    public String addNewNews(Object n){
        News news = (News) n;

        String sql = null;
        Object[] objects = null;
        if(news.getAuthor().equals("")){
            sql = "INSERT INTO News (title_news,text_nest) values (?,?)";
            objects = new Object[]{news.getTitle(), news.getText()};
        }else {
            sql = "INSERT INTO News (title_news,text_nest,author) values (?,?,?)";
            objects = new Object[]{news.getTitle(), news.getText(),news.getAuthor()};
        }
        int updata = jdbcTemplate.update(sql,objects);
        return updata == 1 ? "Dodano nowy rekord" : "Nie dodano nowego rekordu";
    }


}
