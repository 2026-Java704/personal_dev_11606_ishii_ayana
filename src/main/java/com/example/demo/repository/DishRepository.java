package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Dish;

public interface DishRepository extends JpaRepository<Dish, Integer> {

}
