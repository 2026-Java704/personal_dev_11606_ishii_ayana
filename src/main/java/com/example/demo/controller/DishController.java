package com.example.demo.controller;

import java.time.LocalDate;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Result;
import com.example.demo.repository.DishRepository;
import com.example.demo.repository.ResultRepository;

@Controller
public class DishController {
	private final HttpSession session;
	private final DishRepository dishRepository;
	private final ResultRepository resultRepository;

	public DishController(HttpSession session, DishRepository dishRepository, ResultRepository resultRepository) {
		this.session = session;
		this.dishRepository = dishRepository;
		this.resultRepository = resultRepository;
	}

	//一覧画面表示
	@GetMapping("/dishes/result")
	public String index(Model model) {
		List<Result> resultList = resultRepository.findAll();
		model.addAttribute("resultList", resultList);

		return "dishesresult";
	}

	//	食事登録（プルダウン）画面表示
	@GetMapping("/dishes/add")
	public String create() {
		return "dishesadd";
	}

	@PostMapping("/dishes/add")
	public String add(
			@RequestParam Integer id,
			@RequestParam(defaultValue = "") LocalDate recordDate,
			@RequestParam(defaultValue = "") String stapleFood,
			@RequestParam(defaultValue = "") String sideDish,
			@RequestParam(defaultValue = "") String mainDish,
			@RequestParam(defaultValue = "") String milkDish,
			@RequestParam(defaultValue = "") String fruitCount,
			Model model) {
		Integer userId = (Integer) session.getAttribute("userId");
		Result result = new Result(recordDate, stapleFood, sideDish, mainDish, milkDish, fruitCount);

		int achievement = sumAchievement(
				stapleFood,
				sideDish,
				mainDish,
				milkDish,
				fruitCount);
		result.setAchievement(achievement);
		resultRepository.save(result);
		return "redirect:/dishresult";
	}

	//食事登録内容登録ボタン実行（摂取数選択後、登録）
	@PostMapping("/dishes/add")
	public String sent(
			@RequestParam(defaultValue = "") String dishId,
			Model model) {
		model.addAttribute("dishId", dishId);

		return "dishesresult";
	}

	//	//	登録画面詳細登録ボタン実行
	//	@PostMapping("/dishes/note")
	//	public String show() {
	//		return "dishesnote";
	//	}

	//	食事詳細（メモ）画面表示
	@GetMapping("/dishes/note")
	public String note() {
		return "dishesnote";
	}

}