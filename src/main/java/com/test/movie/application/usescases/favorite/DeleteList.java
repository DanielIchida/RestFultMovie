package com.test.movie.application.usescases.favorite;

import com.test.movie.application.repository.FavoriteListRepository;

public class DeleteList {

    private final FavoriteListRepository favoriteListRepository;

    public DeleteList(FavoriteListRepository favoriteListRepository) {
        this.favoriteListRepository = favoriteListRepository;
    }

    public boolean invoke(int id) {
        return favoriteListRepository.delete(id);
    }
}
