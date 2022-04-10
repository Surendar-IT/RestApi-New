package com.spring.boot.restapi;

public class ProjectExceptionResponse {

	private String response;

		public ProjectExceptionResponse(String response) {
		this.response = response;
		}

		public String getId() {
			return response;
		}

		public void setemailAddress(String response) {
			this.response = response;
		}
	
	
}
