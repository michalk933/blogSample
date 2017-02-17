package com.example.blogSample.service;


import java.util.List;

public interface ServiceInterface <T> {

    List<T> getObj();// pobranie rekordów z bazy danych
    T create(T obj);// stworzenie nowego rekordu
    T findById(String id);// szukanie rekordu po id
    T update(T obj);// modyfikacja rekordu

}
