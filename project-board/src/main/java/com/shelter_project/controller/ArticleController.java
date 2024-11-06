package com.shelter_project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shelter_project.PageDTO;
import com.shelter_project.domain.ArticleDTO;
import com.shelter_project.service.ArticleService;

@Controller
public class ArticleController {

	@Autowired
	ArticleService ArtService;
	
	@PostMapping("/searchProc")
	public String searchProc(Model model, RedirectAttributes rs,
			@RequestParam(value = "search-Type", required = false) String searchType,
			@RequestParam(value = "search-Value",required = false) String searchValue,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
	
		ArrayList<ArticleDTO> boards = ArtService.serachList(page,searchType,searchValue);
		PageDTO pageDTO = ArtService.pagingParam(page,searchType,searchValue);
		
		rs.addFlashAttribute("msg","검색 성공");
		rs.addFlashAttribute("boards", boards);
		rs.addFlashAttribute("paging", pageDTO);
		rs.addFlashAttribute("searchType", searchType);
		rs.addFlashAttribute("searchValue", searchValue);
		return "redirect:/index";
	}
}
