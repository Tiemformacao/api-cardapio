package com.projeto.cardapio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.cardapio.model.Food;
import com.projeto.cardapio.model.FoodRequestDTO;
import com.projeto.cardapio.model.FoodResponseDTO;
import com.projeto.cardapio.repository.FoodRepository;

@RestController
@RequestMapping("/food")
public class FoodController {
	
	@Autowired
	private FoodRepository foodRepository;
	
	// 2º Método criado: Enviar dados para a aplicação;
	// Método para publicar uma comida no cardápio;
	// É só ir no postman e mandar dados no método POST;
	@PostMapping
	public void saveFood(@RequestBody FoodRequestDTO data) {
		Food foodData = new Food(data);
		foodRepository.save(foodData);
	}
	
	// 1º Método criado: Mostrar os dados da nossa entidade;
	//Quando digitarem a url/food através do método GET, é esse método que será chamado;
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	public List<FoodResponseDTO> getAll() {
		
		// Este método trás todos os dados do banco de dados foods; (É só uma o postman: localhost:8080/food)
		// Transformar a Entidade Food em DTO;
		// Método stream: Vai pegar tudo que está vindo do repositório (com o método findAll) e colocar em um funil;
		// Método map: Para cada objeto que está dentro do funil, vamos criar um DTO;
		List<FoodResponseDTO> foodList = (List<FoodResponseDTO>) foodRepository.findAll().stream().map(FoodResponseDTO::new).toList();
		return foodList;
	}
}
