package com.test.movie.infrastructure.restful.controllers.favorites;

import com.test.movie.application.usescases.favorite.DeleteList;
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

@Tag(name = "Delete List Favorite", description = "Delete List Favorite")
@RestController
public class DeleteListController extends BaseListController{

    @Autowired
    private DeleteList deleteList;

    @Operation(
            summary = "Delete List Favorite",
            description = "Delete List Favorite",
            tags = { "favorites", "delete" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            return oKMessage(deleteList.invoke(id));
        } catch (Exception ex) {
            return errorMessage(ex);
        }
    }

}
