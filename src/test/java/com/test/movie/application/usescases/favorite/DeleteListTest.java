package com.test.movie.application.usescases.favorite;

import com.test.movie.application.repository.FavoriteListRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DeleteListTest {

    @InjectMocks
    DeleteList deleteList;

    @Mock
    FavoriteListRepository favoriteListRepository;

    @DisplayName("Validate delete list")
    @Test
    public void validateOkUpdate() {
        int id = 1;
        Mockito.lenient().when(deleteList.invoke(id)).thenReturn(true);
        Mockito.lenient().when(favoriteListRepository.delete(id)).thenReturn(true);
    }


}
