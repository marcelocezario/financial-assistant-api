package br.dev.mhc.financialassistantapi.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.dev.mhc.financialassistantapi.entities.Category;

public class CategoryDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotEmpty(message = "The category's name is a required field")
	@Length(max = 50, message = "Maximum number of 50 characters exceeded")
	private String name;
	private String iconUrl;

	public CategoryDTO() {
	}

	public CategoryDTO(Long id, String name, String iconUrl) {
		super();
		this.id = id;
		this.name = name;
		this.iconUrl = iconUrl;
	}

	public CategoryDTO(Category obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.iconUrl = obj.getIconUrl();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
}
