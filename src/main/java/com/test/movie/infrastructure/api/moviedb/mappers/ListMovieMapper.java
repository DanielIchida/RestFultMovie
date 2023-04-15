package com.test.movie.infrastructure.api.moviedb.mappers;

import com.test.movie.domain.ListMovie;
import com.test.movie.infrastructure.api.moviedb.dto.ListMovieResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.stream.Collectors;

@Mapper
public interface ListMovieMapper {
    ListMovieMapper  INSTANCE = Mappers.getMapper(ListMovieMapper.class);

    default ListMovie movieToMovieResponse(ListMovieResponse listMovieResponse){
        ListMovie listMovie = new ListMovie();
        listMovie.setPage(listMovieResponse.getPage());
        listMovie.setResults(
                listMovieResponse.getResults()
                        .stream()
                        .map(MovieMapper.INSTANCE::movieToMovieResponse)
                        .collect(Collectors.toList())
        );
        listMovie.setTotalPages(listMovieResponse.getTotalPages());
        listMovie.setTotalResults(listMovieResponse.getTotalResults());
        return listMovie;
    }

}
