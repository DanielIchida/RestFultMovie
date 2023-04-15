package com.test.movie.infrastructure.restful.dto.mappers;

import com.test.movie.domain.FavoriteList;

import com.test.movie.infrastructure.restful.dto.request.ListRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ListRequestMapper {

    ListRequestMapper INSTANCE = Mappers.getMapper(ListRequestMapper.class);

    default FavoriteList favoriteToListRequest(ListRequest request) {
        FavoriteList favoriteList = new FavoriteList();
        favoriteList.setName(request.getName());
        favoriteList.setDescription(request.getDescription());
        return favoriteList;
    }

    default ListRequest favoriteToListRequest(FavoriteList request) {
        ListRequest listRequest = new ListRequest();
        listRequest.setName(request.getName());
        listRequest.setDescription(request.getDescription());
        return listRequest;
    }

}
