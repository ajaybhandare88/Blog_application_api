package com.project.api.blog.helper;

import java.util.List;

public class PaginationDetails {
	
	private List<PostDto> listOfPostDto; 
	private int currentPageNumber;
	private int totalPageNumber;
	private int PageDataValue;
	private boolean isLast;
	
	public PaginationDetails(List<PostDto> listOfPostDto, int currentPageNumber, int totalPageNumber, int pageDataValue,
			boolean isLast) {
		super();
		this.listOfPostDto = listOfPostDto;
		this.currentPageNumber = currentPageNumber;
		this.totalPageNumber = totalPageNumber;
		PageDataValue = pageDataValue;
		this.isLast = isLast;
	}

	public PaginationDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<PostDto> getListOfPostDto() {
		return listOfPostDto;
	}

	public void setListOfPostDto(List<PostDto> listOfPostDto) {
		this.listOfPostDto = listOfPostDto;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public void setCurrentPageNumber(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}

	public int getTotalPageNumber() {
		return totalPageNumber;
	}

	public void setTotalPageNumber(int totalPageNumber) {
		this.totalPageNumber = totalPageNumber;
	}

	public int getPageDataValue() {
		return PageDataValue;
	}

	public void setPageDataValue(int pageDataValue) {
		PageDataValue = pageDataValue;
	}

	public boolean isLast() {
		return isLast;
	}

	public void setLast(boolean isLast) {
		this.isLast = isLast;
	}

	
	
}
