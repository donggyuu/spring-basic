package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Country;
import com.example.demo.repositories.CountryRepository;

@Controller
public class PageController {
	
	@Autowired
	private CountryRepository countryRepository;
	

	@GetMapping("/")
	public String showPage(Model model, @RequestParam(defaultValue="0") int page) {
		
		// 이 부분이 이해 잘 안감. 
		model.addAttribute("data", countryRepository.findAll(new PageRequest(page, 4)));

		PageRequest pr = new PageRequest(page, 4);
		
		
		return "index";
	}
	
	@PostMapping	("/save")
	public String saveCountry(Country country) {
		countryRepository.save(country);
		
		return "redirect:/"; 
	}

	@GetMapping("/delete")
	public String deleteCountry(Country country) {
		countryRepository.delete(country);
		
		return "redirect:/"; 
	}

//	// 에러발생구문. 추후 확인.
//	@GetMapping("/findOne")
//	@ResponseBody
//	public Country findOne(Integer id) {
//		countryRepository.findOne(id);
//	}
	
	
}
