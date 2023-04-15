package com.test.movie.application.usescases.favorite;

import com.test.movie.application.repository.FavoriteListRepository;
import com.test.movie.domain.FavoriteList;

public class AddList {

    private final FavoriteListRepository favoriteListRepository;

    public AddList(FavoriteListRepository favoriteListRepository) {
        this.favoriteListRepository = favoriteListRepository;
    }

    public FavoriteList invoke(FavoriteList favoriteList){
        return favoriteListRepository.add(favoriteList);
    }

}