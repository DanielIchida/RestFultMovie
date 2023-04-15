package com.test.movie.application.usescases.movie;

import com.test.movie.application.repository.MovieRepository;
import com.test.movie.domain.ListMovie;
import com.test.movie.domain.Movie;

import java.util.List;

public class GetListSearch {

    private final MovieRepository movieRepository;

    public GetListSearch(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public ListMovie invoke(String query, int page){
        return movieRepository.getListSearch(query,page);
    }

}
