package com.test.movie.infrastructure.api.moviedb.resources.services;

import com.test.movie.infrastructure.api.moviedb.dto.EditRequest;
import com.test.movie.infrastructure.api.moviedb.dto.EditResponse;
import com.test.movie.infrastructure.api.moviedb.dto.ListResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FavoriteServices extends BaseServices{

    private static final String URL_LIST = "/list";

    public ListResponse getListById(int id) {
         return this.baseUrlVersionHeaders()
                 .get()
                 .uri(URL_LIST+"/"+id)
                 .retrieve()
                 .bodyToMono(ListResponse.class)
                 .block();
    }

    public EditResponse addList(EditRequest request) {
         return this.baseUrlVersionHeaders()
                 .post()
                 .uri(URL_LIST)
                 .body(Mono.just(request),EditRequest.class)
                 .retrieve()
                 .bodyToMono(EditResponse.class)
                 .block();
    }

    public EditResponse updateList(int id,EditRequest request) {
        return this.baseUrlVersionHeaders()
                .put()
                .uri(URL_LIST+"/"+id)
                .body(Mono.just(request), EditRequest.class)
                .retrieve()
                .bodyToMono(EditResponse.class)
                .block();
    }

    public EditResponse deleteList(int id) {
        return this.baseUrlVersionHeaders()
                .delete()
                .uri(URL_LIST+"/"+id)
                .retrieve()
                .bodyToMono(EditResponse.class)
                .block();
    }

}
