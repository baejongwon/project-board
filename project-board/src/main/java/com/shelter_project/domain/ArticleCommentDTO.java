package com.shelter_project.domain;

public class ArticleCommentDTO {

	private int id;
	private String article_id;
	private String content;
	private String cratedAt;
	private String createBy;
	private String modifyedAt;
	private String modifyedBy;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArticle_id() {
		return article_id;
	}
	public void setArticle_id(String article_id) {
		this.article_id = article_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCratedAt() {
		return cratedAt;
	}
	public void setCratedAt(String cratedAt) {
		this.cratedAt = cratedAt;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getModifyedAt() {
		return modifyedAt;
	}
	public void setModifyedAt(String modifyedAt) {
		this.modifyedAt = modifyedAt;
	}
	public String getModifyedBy() {
		return modifyedBy;
	}
	public void setModifyedBy(String modifyedBy) {
		this.modifyedBy = modifyedBy;
	}
	
	
}
