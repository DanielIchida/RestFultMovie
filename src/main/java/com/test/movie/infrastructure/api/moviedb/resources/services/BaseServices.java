package com.test.movie.infrastructure.api.moviedb.resources.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public abstract class BaseServices {

    @Value("${moviedb.url}")
    protected String URL;
    @Value("${moviedb.apikey}")
    protected String API_KEY;
    @Value("${moviedb.token}")
    protected String TOKEN;
    protected static final int VERSION_API_THREE = 3;
    protected static final int VERSION_API_FOUR = 4;
    protected static String BEARER = "Bearer ";
    protected static String HEADER = "Authorization";
    protected static String PARAM_API_KEY = "?api_key=";

    @Autowired
    private WebClient.Builder client;

    private WebClient.Builder baseUrlVersionBuilder(int version) {
        return client
                .baseUrl(URL+version);
    }

    protected WebClient baseUrlVersion() {
        return baseUrlVersionBuilder(BaseServices.VERSION_API_THREE).build();
    }

    protected WebClient baseUrlVersionHeaders() {
        return baseUrlVersionBuilder(BaseServices.VERSION_API_FOUR)
                .defaultHeader(HEADER,BEARER+TOKEN)
                .build();
    }
}
