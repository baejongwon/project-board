package com.shelter_project.Mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.shelter_project.domain.ArticleDTO;


@Mapper
public interface ArticleMapper {

	ArrayList<ArticleDTO> getList(Map<String, Integer> pagingParams);

	ArrayList<ArticleDTO> serachList(Map<String, Integer> pagingParams, @Param("searchType") String searchType,
			@Param("searchValue") String searchValue);

	int getBoardCount();

	ArrayList<ArticleDTO> serachList(Map<String, Object> pagingParams);

	int getSearchCount(Map<String, Object> params);

}
