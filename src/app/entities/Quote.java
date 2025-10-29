package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Quote {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column
	private Long pk;
	
	@Column
	private String message;
	
	@Column
	private String category;

	public Long getId() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Quote [pk=" + pk + ", message=" + message + ", category=" + category + "]";
	}
	
}
