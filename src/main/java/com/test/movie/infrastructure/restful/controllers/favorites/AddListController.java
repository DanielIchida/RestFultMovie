package com.test.movie.infrastructure.restful.controllers.favorites;

import com.test.movie.application.usescases.favorite.AddList;
import com.test.movie.infrastructure.restful.dto.mappers.EditResponseMapper;
import com.test.movie.infrastructure.restful.dto.mappers.ListRequestMapper;
import com.test.movie.infrastructure.restful.dto.request.ListRequest;
import com.test.movie.infrastructure.restful.dto.response.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Add List Favorite", description = "Add List Favorite")
@RestController
public class AddListController extends BaseListController{

    @Autowired
    private AddList addList;

    @Operation(
            summary = "Add List Favorite",
            description = "Add List Favorite",
            tags = { "favorites", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping
    public ResponseEntity<?> add(@RequestBody ListRequest request) {
        try {
            return oKMessage(EditResponseMapper.INSTANCE.editResponseDtoToFavoriteList(
                    addList.invoke(ListRequestMapper.INSTANCE.favoriteToListRequest(request))
            ));
        } catch (Exception ex) {
            return errorMessage(ex);
        }
    }

}
