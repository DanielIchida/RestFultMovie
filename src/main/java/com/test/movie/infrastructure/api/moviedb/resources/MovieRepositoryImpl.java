package com.test.movie.infrastructure.api.moviedb.resources;

import com.test.movie.application.repository.MovieRepository;
import com.test.movie.domain.ListMovie;
import com.test.movie.domain.Movie;
import com.test.movie.infrastructure.api.moviedb.mappers.ListMovieMapper;
import com.test.movie.infrastructure.api.moviedb.mappers.MovieMapper;
import com.test.movie.infrastructure.api.moviedb.resources.services.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MovieRepositoryImpl implements MovieRepository {

    @Autowired
    MovieServices movieServices;

    @Override
    public ListMovie getListSearch(String query, int page) {
        return ListMovieMapper.INSTANCE.movieToMovieResponse(movieServices.getSearchMovies(query,page));
    }

    @Override
    public Movie getById(int id) {
        return MovieMapper.INSTANCE.movieToMovieResponse(movieServices.getById(id));
    }
}
