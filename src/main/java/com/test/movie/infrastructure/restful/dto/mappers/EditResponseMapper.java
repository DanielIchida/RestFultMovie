package com.test.movie.infrastructure.restful.dto.mappers;

import com.test.movie.domain.FavoriteList;
import com.test.movie.infrastructure.restful.dto.response.EditResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EditResponseMapper {

    EditResponseMapper  INSTANCE = Mappers.getMapper(EditResponseMapper .class);

    default EditResponseDto editResponseDtoToFavoriteList(FavoriteList favoriteList) {
        EditResponseDto editResponseDto = new EditResponseDto();
        editResponseDto.setId(favoriteList.getId());
        editResponseDto.setApiMessage(favoriteList.getStatusMessage());
        return editResponseDto;
    }

}
