package kr.java.springweb.model.repository;


import kr.java.springweb.model.entity.Food;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Component
//@Repository <- SupabaseRepo에서 사용으로 인해 주석처리
public class InMemoryFoodRepository implements FoodRepository {
    private final List<Food> foods = new ArrayList<>();

    public InMemoryFoodRepository() {
        System.out.println("InMemoryFoodRepository 생성");
        System.out.println(System.identityHashCode(this));
    }

    @Override
    public List<Food> findAll() {
        return foods;
    }

    @Override
    public void save(Food food) {
        foods.add(food);
    }
}
