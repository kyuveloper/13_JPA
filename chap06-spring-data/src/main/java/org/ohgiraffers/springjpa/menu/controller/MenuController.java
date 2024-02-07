package org.ohgiraffers.springjpa.menu.controller;

import org.ohgiraffers.springjpa.menu.dto.MenuDTO;
import org.ohgiraffers.springjpa.menu.entity.Menu;
import org.ohgiraffers.springjpa.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController /* api 요청을 처리하기 때문에 뷰리졸버를 타지 않음.. */
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping
    public ResponseEntity<Object> insertMenu(@RequestBody MenuDTO menu) {

        Object result = menuService.insertMenu(menu);

        if (!(result instanceof Menu)) {
            return ResponseEntity.status(404).body("등록 실패");
        }

        Menu response = (Menu) result;

        return ResponseEntity.ok(response);
    }
}
