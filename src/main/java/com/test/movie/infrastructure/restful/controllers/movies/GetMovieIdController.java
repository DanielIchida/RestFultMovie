package com.test.movie.infrastructure.restful.controllers.movies;

import com.test.movie.application.usescases.movie.GetById;
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


@Tag(name = "Get Movie", description = "Get Movie")
@RestController
@RequestMapping("movie")
public class GetMovieIdController extends BaseController {

    @Autowired
    private GetById getById;

    @Operation(
            summary = "Movie Id",
            description = "Movie Id",
            tags = { "movie", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/{id}")
    public ResponseEntity<?> execute(@PathVariable int id){
        try {
            return oKMessage(getById.invoke(id));
        } catch (Exception ex) {
            return errorMessage(ex);
        }
    }

}
