package com.test.movie.application.usescases.movie;

import com.test.movie.application.repository.MovieRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class GetListSearchTest {

    @InjectMocks
    GetListSearch getListSearch;

    @Mock
    MovieRepository movieRepository;

    @DisplayName("Validate get movie by id")
    @Test
    public void validateGetSearchId() {
        Mockito.lenient().when(getListSearch.invoke("Data",1)).thenReturn(null);
        Mockito.lenient().when(movieRepository.getListSearch("Data",1)).thenReturn(null);
    }


}
