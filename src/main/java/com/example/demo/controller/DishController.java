package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.DishRepository;

@Controller
public class DishController {
	private final HttpSession session;
	private final DishRepository dishRepository;

	public DishController(HttpSession session, DishRepository dishRepository) {
		this.session = session;
		this.dishRepository = dishRepository;

	}

	@GetMapping("/result")
	public String index() {
		return "dishesresult";
	}

	@GetMapping("/dishes/add")
	public String add() {
		return "dishesadd";
	}

}