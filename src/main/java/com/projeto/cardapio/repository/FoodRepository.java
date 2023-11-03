package com.projeto.cardapio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.cardapio.model.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
