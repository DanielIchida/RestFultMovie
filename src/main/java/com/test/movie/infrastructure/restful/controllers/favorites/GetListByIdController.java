package com.test.movie.infrastructure.restful.controllers.favorites;


import com.test.movie.application.usescases.favorite.GetList;
import com.test.movie.infrastructure.restful.dto.mappers.FavoriteListMapper;
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


@Tag(name = "Get by id List Favorite", description = "Get by id  List Favorite")
@RestController
public class GetListByIdController extends BaseListController{

    @Autowired
    private GetList getList;

    @Operation(
            summary = "Get by id List Favorite",
            description = "Get by id List Favorite",
            tags = { "favorites", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        try {
            return oKMessage(FavoriteListMapper.INSTANCE.favoriteListDtoToFavoriteList(getList.invoke(id)));
        } catch (Exception ex) {
            return errorMessage(ex);
        }
    }


}
