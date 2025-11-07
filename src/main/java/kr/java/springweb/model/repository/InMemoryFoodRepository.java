package kr.java.springweb.model.repository;


import kr.java.springweb.model.entity.Food;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
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
