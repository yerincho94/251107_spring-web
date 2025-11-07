package kr.java.springweb.controller;

import kr.java.springweb.model.entity.Food;
import kr.java.springweb.model.repository.FoodRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller // @Compotent 포함되어있음
@RequestMapping("/foods")
public class FoodController {
    private final FoodRepository repository;

    // 내가 등록한 건 InMemoryRepo인데, '다형성' 측면에서 어차피 상위 타입이니까 등록만 되면 일단 씀.
    public FoodController(FoodRepository repository) {
        this.repository = repository; // 의존성 주입 -> 생성자 주입
        System.out.println("FoodController 생성");
        System.out.println(System.identityHashCode(this.repository));
    }

    // GET
    @GetMapping // ("/") GET -> /foods
    public String getFoods(Model model) {
        List<Food> foods = repository.findAll();
        model.addAttribute("foods", foods);
        return "foods"; // "foods.jsp" <- views
    }

    // POST
    @PostMapping // ("/") POST -> /foods
    public String postFoods(@RequestParam("name") String name, @RequestParam("price") int price) {
        System.out.println("name: " + name);
        System.out.println("price: " + price);
        repository.save(new Food(name, price));
        return "redirect:/foods"; // GET -> /foods
        // resp -> redirect: -> resp.redirect.
    }
}
