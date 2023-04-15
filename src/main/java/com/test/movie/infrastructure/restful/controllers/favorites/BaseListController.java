package com.test.movie.infrastructure.restful.controllers.favorites;


import com.test.movie.infrastructure.restful.controllers.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("favorite/list")
public abstract class BaseListController extends BaseController {
}
