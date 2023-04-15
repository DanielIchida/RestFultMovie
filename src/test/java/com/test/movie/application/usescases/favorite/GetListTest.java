package com.test.movie.application.usescases.favorite;

import com.test.movie.application.repository.FavoriteListRepository;
import com.test.movie.domain.FavoriteList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GetListTest {

    @InjectMocks
    GetList getList;

    @Mock
    FavoriteListRepository favoriteListRepository;

    @DisplayName("Validate get list")
    @Test
    public void validateOkUpdate() {
        FavoriteList favoriteList = new FavoriteList();
        favoriteList.setId(1);
        favoriteList.setName("List Daniel");
        favoriteList.setDescription("Description List Daniel");
        Mockito.lenient().when(getList.invoke(favoriteList.getId())).thenReturn(favoriteList);
        Mockito.lenient().when(favoriteListRepository.getById(favoriteList.getId())).thenReturn(favoriteList);
    }

}
