package com.cesi.jee.client.controller;

import java.util.List;
import java.util.Map;

import com.cesi.jee.client.model.Category;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.ModelAndView;

@Controller  
public class HomeController {

  String API_URL = "http://127.0.0.1:8000";
  WebClient client = WebClient.create(API_URL);

  @GetMapping("/")
  public ModelAndView home(Map<String, Object> model) {

    List<Category> categories = client.get()
      .uri("/categories")
      .retrieve()
      .bodyToMono(List.class)
      .block();

    System.out.println(categories);
    model.put("categories", categories);
    
    return new ModelAndView("index", model);
  }

  @GetMapping("/categories/{id}")
  public ModelAndView category(Map<String, Object> model, @PathVariable String id) {
    System.out.println(id);

    Category category = client.get()
      .uri("/categories/" + id)
      .retrieve()
      .bodyToMono(Category.class)
      .block();

    System.out.println(category);
    model.put("category", category);
    
    return new ModelAndView("category", model);
  }

}