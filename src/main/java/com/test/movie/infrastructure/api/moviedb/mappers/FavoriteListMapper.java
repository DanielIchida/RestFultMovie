package com.test.movie.infrastructure.api.moviedb.mappers;

import com.test.movie.domain.FavoriteList;
import com.test.movie.infrastructure.api.moviedb.dto.EditRequest;
import com.test.movie.infrastructure.api.moviedb.dto.EditResponse;
import com.test.movie.infrastructure.api.moviedb.dto.ListResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FavoriteListMapper {

    FavoriteListMapper INSTANCE = Mappers.getMapper(FavoriteListMapper.class);

    default FavoriteList favoriteListToEditResponse(EditResponse response) {
        FavoriteList favoriteList = new FavoriteList();
        favoriteList.setId(response.getId());
        favoriteList.setName("");
        favoriteList.setDescription("");
        favoriteList.setStatusMessage(response.getApiMessage());
        return favoriteList;
    }

    default FavoriteList favoriteListToListResponse(ListResponse response) {
        FavoriteList favoriteList = new FavoriteList();
        favoriteList.setId(response.getId());
        favoriteList.setName(response.getName());
        favoriteList.setDescription(response.getDescription());
        favoriteList.setStatusMessage("");
        return favoriteList;
    }

    default EditRequest editRequestToFavoriteList(FavoriteList favoriteList) {
        EditRequest editRequest = new EditRequest();
        editRequest.setDescription(favoriteList.getDescription());
        editRequest.setName(favoriteList.getDescription());
        editRequest.setIso("es");
        return editRequest;
    }

}
