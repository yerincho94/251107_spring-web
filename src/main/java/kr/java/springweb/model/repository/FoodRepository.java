package kr.java.springweb.model.repository;

import kr.java.springweb.model.entity.Food;

import java.util.List;

public interface FoodRepository {
    List<Food> findAll();
    void save(Food food);
}
