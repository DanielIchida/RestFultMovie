package com.test.movie.application.repository;

import com.test.movie.domain.FavoriteList;

public interface FavoriteListRepository {
     FavoriteList update(int id , FavoriteList favoriteList);
     FavoriteList add(FavoriteList favoriteList);
     boolean delete(int id);
     FavoriteList getById(int id);
}
