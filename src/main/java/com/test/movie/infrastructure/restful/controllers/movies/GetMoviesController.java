package com.test.movie.infrastructure.restful.controllers.movies;

import com.test.movie.application.usescases.movie.GetListSearch;
import com.test.movie.infrastructure.restful.controllers.BaseController;
import com.test.movie.infrastructure.restful.dto.response.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Get List Search Movies", description = "Get List Search Movies")
@RestController
@RequestMapping("movies")
public class GetMoviesController extends BaseController {

    @Autowired
    private GetListSearch getListSearch;

    @Operation(
            summary = "Movie List Search",
            description = "Movie List Search first param query and second param page",
            tags = { "movies", "get" })
            @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/{query}/{page}")
    public ResponseEntity<?> execute(@PathVariable String query, @PathVariable(required = false) int page){
         try {
             return oKMessage(getListSearch.invoke(query,page));
         } catch (Exception ex) {
             return errorMessage(ex);
         }
    }

}
