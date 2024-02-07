package org.ohgiraffers.springjpa.order.infra;

import org.ohgiraffers.springjpa.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MenuFindImpl implements MenuFind {

    @Autowired
    private MenuService menuService;

    @Override
    public Integer findMenuCode(int menuCode) {

        Integer findCode = menuService.findMenuCode(menuCode);

        return findCode;
    }
}
