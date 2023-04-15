package com.test.movie.infrastructure.restful.dto.mappers;

import com.test.movie.domain.FavoriteList;
import com.test.movie.infrastructure.restful.dto.response.FavoriteListDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FavoriteListMapper {

    FavoriteListMapper INSTANCE = Mappers.getMapper(FavoriteListMapper.class);

    default FavoriteListDto favoriteListDtoToFavoriteList(FavoriteList favoriteList) {
        FavoriteListDto favoriteListDto = new FavoriteListDto();
        favoriteListDto.setId(favoriteList.getId());
        favoriteListDto.setName(favoriteList.getName());
        favoriteListDto.setDescription(favoriteList.getDescription());
        return favoriteListDto;
    }


}
