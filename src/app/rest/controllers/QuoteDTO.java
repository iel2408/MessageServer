package app.rest.controllers;

public class QuoteDTO {
	private String category;
	private String message;

	public QuoteDTO(String category, String message) {
		this.category = category;
		this.message = message;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}