package com.test.movie.application.usescases.movie;

import com.test.movie.application.repository.MovieRepository;
import com.test.movie.domain.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GetByIdTest {

    @InjectMocks
    GetById getById;

    @Mock
    MovieRepository movieRepository;

    @DisplayName("Validate get movie by id")
    @Test
    public void validateGetId() {
        Movie movie = new Movie();
        movie.setId(1);
        movie.setTitle("Title movie");
        movie.setOverview("Overview Movie");
        Mockito.lenient().when(getById.invoke(movie.getId())).thenReturn(movie);
        Mockito.lenient().when(movieRepository.getById(movie.getId())).thenReturn(movie);
    }

}
