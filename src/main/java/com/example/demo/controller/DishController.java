package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.DishRepository;

@Controller
public class DishController {
	private final HttpSession session;
	private final DishRepository dishRepository;

	public DishController(HttpSession session, DishRepository dishRepository) {
		this.session = session;
		this.dishRepository = dishRepository;

	}

	//	食事登録（プルダウン）表示
	@GetMapping("/dishes/add")
	public String add(
			@RequestParam(defaultValue = "") String id,
			Model model) {
		model.addAttribute("id", id);
		return "dishesadd";

	}

	//食事登録内容登録実行（摂取数選択後、登録）
	@PostMapping("/dishes/add")
	public String sent(
			@RequestParam(defaultValue = "") String dishId,
			Model model) {
		model.addAttribute("dishId", dishId);

		return "dishesresult";
	}

	//食事登録内容一覧表示
	@GetMapping("/dishes/result")
	public String index() {
		return "dishesresult";
	}

	//	//	登録画面詳細登録ボタンクリック
	//	@PostMapping("/dishes/note")
	//	public String show() {
	//		return "dishesnote";
	//	}

	//	食事詳細画面表示
	@GetMapping("/dishes/note")
	public String note() {
		return "dishesnote";
	}

}