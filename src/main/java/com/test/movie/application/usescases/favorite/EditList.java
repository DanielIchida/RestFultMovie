package com.test.movie.application.usescases.favorite;

import com.test.movie.application.repository.FavoriteListRepository;
import com.test.movie.domain.FavoriteList;

public class EditList {

    private final FavoriteListRepository favoriteListRepository;

    public EditList(FavoriteListRepository favoriteListRepository) {
        this.favoriteListRepository = favoriteListRepository;
    }

    public FavoriteList invoke(int id,FavoriteList favoriteList){
        return favoriteListRepository.update(id,favoriteList);
    }

}