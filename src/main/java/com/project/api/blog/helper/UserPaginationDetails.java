package com.project.api.blog.helper;

import java.util.List;

public class UserPaginationDetails {

		
		private List<UserDto> listOfUserDto; 
		private int currentPageNumber;
		private int totalPageNumber;
		private int PageDataValue;
		private boolean isLast;
		public UserPaginationDetails(List<UserDto> listOfUserDto, int currentPageNumber, int totalPageNumber,
				int pageDataValue, boolean isLast) {
			super();
			this.listOfUserDto = listOfUserDto;
			this.currentPageNumber = currentPageNumber;
			this.totalPageNumber = totalPageNumber;
			PageDataValue = pageDataValue;
			this.isLast = isLast;
		}
		public UserPaginationDetails() {
			super();
			// TODO Auto-generated constructor stub
		}
		public List<UserDto> getListOfUserDto() {
			return listOfUserDto;
		}
		public void setListOfUserDto(List<UserDto> listOfUserDto) {
			this.listOfUserDto = listOfUserDto;
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

	

