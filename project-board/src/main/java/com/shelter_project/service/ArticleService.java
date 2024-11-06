package com.shelter_project.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shelter_project.PageDTO;
import com.shelter_project.Mapper.ArticleMapper;
import com.shelter_project.domain.ArticleDTO;

@Service
public class ArticleService {

	@Autowired
	ArticleMapper mapper;

	// 한 페이지당 보여줄 글의 갯수
	int pageLimit = 5;
	// 하단에 보여줄 페이지 번호 갯수
	int blockLimit = 5;

	public PageDTO pagingParam(int page, String searchType, String searchValue) {
		// 전체 글 갯수 조회
		int boardCount;

		Map<String, Object> params = new HashMap<>();
		params.put("searchType", searchType);
		params.put("searchValue", searchValue);

		if (searchType != null && searchValue != null && !searchValue.isEmpty()) {
			boardCount = mapper.getSearchCount(params); // 검색 조건이 있을 때 검색 결과 개수
		} else {
			boardCount = mapper.getBoardCount(); // 검색 조건이 없을 때 전체 게시물 개수
		}

		// 전체 페이지 갯수 계산(10/3=3.33333 => 4)
		int maxPage = (int) (Math.ceil((double) boardCount / pageLimit));
		// 시작 페이지 값 계산(1, 4, 7, 10, ~~~~)
		int startPage = (((int) (Math.ceil((double) page / blockLimit))) - 1) * blockLimit + 1;
		// 끝 페이지 값 계산(3, 6, 9, 12, ~~~~)
		int endPage = startPage + blockLimit - 1;

		if (endPage > maxPage) {
			endPage = maxPage;
		}

		PageDTO pageDTO = new PageDTO();
		pageDTO.setPage(page);
		pageDTO.setMaxPage(maxPage);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		return pageDTO;
	}

	public ArrayList<ArticleDTO> getList(int page) {
		int pagingStart = (page - 1) * pageLimit;
		Map<String, Integer> pagingParams = new HashMap<>();
		pagingParams.put("start", pagingStart);
		pagingParams.put("limit", pageLimit);
		return mapper.getList(pagingParams);
	}

	public ArrayList<ArticleDTO> serachList(int page, String searchType, String searchValue) {
		int pagingStart = (page - 1) * pageLimit;
		Map<String, Object> pagingParams = new HashMap<>();
		pagingParams.put("start", pagingStart);
		pagingParams.put("limit", pageLimit);
		pagingParams.put("searchType", searchType);
		pagingParams.put("searchValue", searchValue);
		return mapper.serachList(pagingParams);
	}

}
