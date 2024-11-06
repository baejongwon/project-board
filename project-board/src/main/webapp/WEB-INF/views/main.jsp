<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 페이지</title>
<script>
	<c:if test="${msg!=null}">
		alert("${msg}")
	</c:if>
</script>
</head>
<body>

	<main>
		<form action="/searchProc" method="post">
			<label for="serach-Type" hidden>유형</label> <select id="search-Type"
				name="search-Type">
				<option>제목</option>
				<option>본문</option>
				<option>닉네임</option>
				<option>해쉬태그</option>
			</select> <label for="search-value"></label> <input type="serach"
				placeholder="검색..." name="search-Value" id="search-Value">
			<button type="submit">검색</button>
		</form>

		<table>
			<thead>
				<tr>
					<th>제목</th>
					<th>해시태그</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<c:forEach var="board" items="${boards }">
				<tbody>
					<tr>
						<th>${board.content }</th>
						<th>${board.hashtag }</th>
						<th>${board.createdBy }</th>
						<th>${board.createdAt }</th>
					</tr>
				</tbody>
			</c:forEach>
		</table>

		<div class="pagination">
			<c:choose>
				<c:when test="${paging.page <= 1}">
					<span class="prev disabled">&lt;</span>
				</c:when>
				<c:otherwise>
					<a
						href="main?page=${paging.page - 1}&search-Type=${searchType}&search-Value=${searchValue}"
						class="prev">&lt;</a>
				</c:otherwise>
			</c:choose>

			<c:forEach begin="${paging.startPage}" end="${paging.endPage}"
				var="i" step="1">
				<c:choose>
					<c:when test="${i eq paging.page}">
						<span class="current">${i}</span>
					</c:when>
					<c:otherwise>
						<a
							href="main?page=${i}&search-Type=${searchType}&search-Value=${searchValue}">${i}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<c:choose>
				<c:when test="${paging.page >= paging.maxPage}">
					<span class="next disabled">&gt;</span>
				</c:when>
				<c:otherwise>
					<a
						href="main?page=${paging.page + 1}&search-Type=${searchType}&search-Value=${searchValue}"
						class="next">&gt;</a>
				</c:otherwise>
			</c:choose>
		</div>
	</main>

</body>
</html>