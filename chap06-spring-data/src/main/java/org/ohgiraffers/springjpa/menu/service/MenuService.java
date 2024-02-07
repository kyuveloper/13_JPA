package org.ohgiraffers.springjpa.menu.service;

import org.ohgiraffers.springjpa.menu.dto.MenuDTO;
import org.ohgiraffers.springjpa.menu.entity.Menu;
import org.ohgiraffers.springjpa.menu.infra.CategoryFind;
import org.ohgiraffers.springjpa.menu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private CategoryFind categoryFind; // 느슨한 결합구조를 위해서..

    public Object insertMenu(MenuDTO menuDTO) {
        // 도메인 로직 작성
        // 메뉴 이름이 존재하는가?
        Menu menu = menuRepository.findByMenuName(menuDTO.getMenuName());

        if (!Objects.isNull(menu)) {
            return new String(menuDTO.getMenuName() + "의 메뉴가 존재한다.");
        }

        // 가격 정보 확인
        if (menuDTO.getMenuPrice() < 0) {
            return new String(menuDTO.getMenuPrice() + "이걸 팔아서 장사를 어떻게하나?");
        }

        // 카테고리 코드 조회
        Integer categoryCode = categoryFind.getCategory(menuDTO.getCategoryCode());

        if (Objects.isNull(categoryCode)) {
            return new String(menuDTO.getCategoryCode() + "는 존재하지 않습니다.");
        }

        Menu newMenu = new Menu();
        newMenu.setMenuName(menuDTO.getMenuName());
        newMenu.setMenuPrice(menuDTO.getMenuPrice());
        newMenu.setCategory(menuDTO.getCategoryCode());

        Menu result = menuRepository.save(newMenu);

        return result;

    }

    public Integer findMenuCode(Integer menuCode) {

        Menu findMenu = menuRepository.findByMenuCode(menuCode);

        if (Objects.isNull(findMenu)) {
            return null;
        }

        return findMenu.getMenuCode();
    }

}
