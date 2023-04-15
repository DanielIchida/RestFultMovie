package com.test.movie.infrastructure.config;

import com.test.movie.application.repository.FavoriteListRepository;
import com.test.movie.application.repository.MovieRepository;
import com.test.movie.application.usescases.favorite.AddList;
import com.test.movie.application.usescases.favorite.DeleteList;
import com.test.movie.application.usescases.favorite.EditList;
import com.test.movie.application.usescases.favorite.GetList;
import com.test.movie.application.usescases.movie.GetById;
import com.test.movie.application.usescases.movie.GetListSearch;
import com.test.movie.infrastructure.api.moviedb.resources.MovieRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootServiceConfig {

    @Bean
    public GetById getById(MovieRepository movieRepository) {
        return new GetById(movieRepository);
    }

    @Bean
    public GetListSearch getListSearch(MovieRepository movieRepository) {
        return new GetListSearch(movieRepository);
    }

    @Bean
    public AddList addList(FavoriteListRepository favoriteListRepository) {
        return new AddList(favoriteListRepository);
    }

    @Bean
    public EditList editList(FavoriteListRepository favoriteListRepository) {
        return new EditList(favoriteListRepository);
    }

    @Bean
    public DeleteList deleteList(FavoriteListRepository favoriteListRepository) {
        return new DeleteList(favoriteListRepository);
    }

    @Bean
    public GetList getList(FavoriteListRepository favoriteListRepository) {
        return new GetList(favoriteListRepository);
    }

}
