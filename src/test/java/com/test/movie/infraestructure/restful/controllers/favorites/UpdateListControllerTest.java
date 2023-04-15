package com.test.movie.infraestructure.restful.controllers.favorites;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.movie.application.usescases.favorite.AddList;
import com.test.movie.application.usescases.favorite.EditList;
import com.test.movie.domain.FavoriteList;
import com.test.movie.infrastructure.restful.controllers.favorites.AddListController;
import com.test.movie.infrastructure.restful.controllers.favorites.UpdateListController;
import com.test.movie.infrastructure.restful.dto.mappers.ListRequestMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class UpdateListControllerTest {

    @InjectMocks
    UpdateListController updateListController;

    @Mock
    EditList editList;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void shouldTestOk(){
        FavoriteList favoriteList = new FavoriteList();
        favoriteList.setId(1);
        favoriteList.setName("List Daniel");
        favoriteList.setDescription("Description List Daniel");
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Mockito.when(editList.invoke(1,favoriteList)).thenReturn(favoriteList);
        ResponseEntity<?> response = updateListController.update(1,ListRequestMapper.INSTANCE.favoriteToListRequest(favoriteList));
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
