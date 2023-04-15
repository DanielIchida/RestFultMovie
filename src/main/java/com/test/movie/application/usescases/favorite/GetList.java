package com.test.movie.application.usescases.favorite;

import com.test.movie.application.repository.FavoriteListRepository;
import com.test.movie.domain.FavoriteList;

public class GetList {

    private final FavoriteListRepository favoriteListRepository;

    public GetList(FavoriteListRepository favoriteListRepository) {
        this.favoriteListRepository = favoriteListRepository;
    }

    public FavoriteList invoke(int id) {
        return favoriteListRepository.getById(id);
    }

}
