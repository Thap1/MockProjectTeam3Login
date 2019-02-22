package com.spring.cmc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Menu implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="menu_id")
	private int menuId;
	
	@Column(name = "menu_description")
	private String menuDescription;
	
	@Column(name = "menu_function")
	private String menuFunction;
	
	@Column(name = "menu_name")
	private String menuName;
	
	@ManyToMany(mappedBy="menus", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnoreProperties("menus")
	private List<Role> roles_menu;

	public Menu() {
		super();
	}

	public Menu(int menuId, String menuDescription, String menuFunction, String menuName) {
		super();
		this.menuId = menuId;
		this.menuDescription = menuDescription;
		this.menuFunction = menuFunction;
		this.menuName = menuName;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuDescription() {
		return menuDescription;
	}

	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}

	public String getMenuFunction() {
		return menuFunction;
	}

	public void setMenuFunction(String menuFunction) {
		this.menuFunction = menuFunction;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
