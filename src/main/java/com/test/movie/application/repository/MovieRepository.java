package com.test.movie.application.repository;

import com.test.movie.domain.ListMovie;
import com.test.movie.domain.Movie;


public interface MovieRepository {
    ListMovie getListSearch(String query, int page);
    Movie getById(int id);
}
