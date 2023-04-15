package com.test.movie.infrastructure.api.moviedb.mappers;

import com.test.movie.domain.Movie;
import com.test.movie.infrastructure.api.moviedb.dto.MovieResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    default Movie movieToMovieResponse(MovieResponse movieResponse){
        Movie movie = new Movie();
        movie.setId(movieResponse.getId());
        movie.setTitle(movieResponse.getTitle());
        movie.setOverview(movieResponse.getOverview());
        return movie;
    }

}
