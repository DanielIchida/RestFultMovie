package com.test.movie.application.usescases.movie;

import com.test.movie.application.repository.MovieRepository;
import com.test.movie.domain.Movie;

public class GetById {

    private final MovieRepository movieRepository;

    public GetById(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie invoke(int id) {
        return movieRepository.getById(id);
    }

}
