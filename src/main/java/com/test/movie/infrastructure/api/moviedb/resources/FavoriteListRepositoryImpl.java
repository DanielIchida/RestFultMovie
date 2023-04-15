package com.test.movie.infrastructure.api.moviedb.resources;

import com.test.movie.application.repository.FavoriteListRepository;
import com.test.movie.domain.FavoriteList;
import com.test.movie.infrastructure.api.moviedb.dto.EditResponse;
import com.test.movie.infrastructure.api.moviedb.mappers.FavoriteListMapper;
import com.test.movie.infrastructure.api.moviedb.resources.services.FavoriteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteListRepositoryImpl implements FavoriteListRepository {

    @Autowired
    FavoriteServices favoriteServices;

    @Override
    public FavoriteList update(int id, FavoriteList favoriteList) {
        return FavoriteListMapper.INSTANCE.favoriteListToEditResponse(
             favoriteServices.updateList(
                     id,
                     FavoriteListMapper.INSTANCE.editRequestToFavoriteList(favoriteList)
             )
        );
    }

    @Override
    public FavoriteList add(FavoriteList favoriteList) {
        return FavoriteListMapper.INSTANCE.favoriteListToEditResponse(
                favoriteServices.addList(
                        FavoriteListMapper.INSTANCE.editRequestToFavoriteList(favoriteList)
                )
        );
    }

    @Override
    public boolean delete(int id) {
        EditResponse response = favoriteServices.deleteList(id);
        return response.isSuccess();
    }

    @Override
    public FavoriteList getById(int id) {
        return FavoriteListMapper.INSTANCE.favoriteListToListResponse(
                favoriteServices.getListById(id)
        );
    }
}
