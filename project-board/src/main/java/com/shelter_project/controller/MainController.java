package com.shelter_project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shelter_project.PageDTO;
import com.shelter_project.domain.ArticleDTO;
import com.shelter_project.service.ArticleService;

@Controller
public class MainController {

	@Autowired
	ArticleService ArtService;
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	@RequestMapping("/header")
	public String header() {
		return "header";
	}
	
	@RequestMapping("/main")
	public String main(Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1")int page,
			@RequestParam(value = "searchType", required = false)String searchType,
			@RequestParam(value = "searchValue", required = false)String searchValue) {
		if(model.containsAttribute("boards")) {
		
		}else {
			ArrayList<ArticleDTO> boards = ArtService.getList(page);
			PageDTO pageDTO = ArtService.pagingParam(page,searchType,searchValue);
			model.addAttribute("boards",boards);
			model.addAttribute("paging",pageDTO);
			
		}
	
		return "main";
	}
	
	@RequestMapping("/footer")
	public String bottom() {
		return "footer";
	}
	
}
