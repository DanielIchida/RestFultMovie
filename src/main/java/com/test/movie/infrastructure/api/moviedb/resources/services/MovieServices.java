package com.test.movie.infrastructure.api.moviedb.resources.services;

import com.test.movie.infrastructure.api.moviedb.dto.ListMovieResponse;
import com.test.movie.infrastructure.api.moviedb.dto.MovieResponse;
import org.springframework.stereotype.Service;


@Service
public class MovieServices extends BaseServices {

    private static final String URL_SEARCH_MOVIES = "/search/movie";
    private static final String URL_MOVIE = "/movie/";
    private static final String PARAM_QUERY = "&query=";
    private static final String PARAM_PAGE = "&page=";


    public ListMovieResponse getSearchMovies(String query,int page) {
         return this.baseUrlVersion()
                 .get()
                 .uri(URL_SEARCH_MOVIES+PARAM_API_KEY+API_KEY+PARAM_QUERY+query+PARAM_PAGE+page)
                 .retrieve()
                 .bodyToMono(ListMovieResponse.class)
                 .block();
    }

    public MovieResponse getById(int id) {
        return this.baseUrlVersion()
                .get()
                .uri(URL_MOVIE+id+PARAM_API_KEY+API_KEY)
                .retrieve()
                .bodyToMono(MovieResponse.class)
                .block();
    }

}
