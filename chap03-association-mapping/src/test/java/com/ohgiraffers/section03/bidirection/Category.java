package com.ohgiraffers.section03.bidirection;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/*
* 양방향 매핑에서 어느 한 쪽ㅇ이 연관 관계의 주인이 되면, 주인이 아닌 쪽에서는 속성을 지정해주어야 한다.
* 이 때, 연관 관계의 주인이 아닌 객체 MappedBy 를 써서 연관 관계의 주인 객체의 필드명을 매핑 시켜 놓으면 양방향 관계를 적용할 수 있다.
* */
@Entity(name = "bidirection_category")
@Table(name = "tbl_category")
public class Category {

    @Id
    @Column(name = "category_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryCode;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "ref_category_code")
    private Integer refCategoryCode;

    // 나랑 연관 관계를 맺고 있는 상대의 필드를 입력 (주인이 아닌 쪽에 입력)
    // 연관 관계의 주인이 아니기 때문에 조회만 가능하다
    @OneToMany(mappedBy = "categoryCode", cascade = CascadeType.PERSIST)
    private List<Menu> menuList = new ArrayList<>();

    public Category() {
    }

    public Category(int categoryCode, String categoryName, Integer refCategoryCode) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }

    public void setRefCategoryCode(Integer refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {

        // 영속성 컨텍스트와 생명주기를 알아야 작성할 수 있는 코드라고 한다
//        List<Menu> newList = new ArrayList<>();
//        for (Menu m : menuList) {
//            m.setCategoryCode(this.categoryCode);
//            newList.add(m);
//        }
//        this.menuList = newList;

        List<Menu> list = new ArrayList<>();
        for (Menu m : menuList) {
            m.setCategoryCode(this);
            list.add(m);
        }

        this.menuList = list;

    }

    @Override
    public String toString() {
        return "CategoryAndMenu{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                ", menuList=" + menuList +
                '}';
    }
}
