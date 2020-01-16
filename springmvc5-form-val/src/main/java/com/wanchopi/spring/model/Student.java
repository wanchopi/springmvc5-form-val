package com.wanchopi.spring.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity
 * @author Wanchopi
 *
 */
public class Student {
	
	@NotNull(message = "Campo requerido")
	@Size(min = 3, max = 25, message = "entre 3 y 25 caracteres")
	private String userName;
	
	@NotEmpty(message = "Campo requerido")
	@Email(message = "Introduzca un email válido")
	private String email;
	
	@NotNull(message = "Campo requerido")
	@Pattern(regexp = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{4,6}$", message=""
			+ "La contraseña debe de tener entre 4 y 8 caracteres, \n"
			+ "al menos un dígito, al menos una mayúscula, al menos una minúscula.\n"
			+ "No puede contener otros símbolos")
	private String password;
	
	@NotNull (message = "Campo requerido")
	private String gender;
	
	@NotNull(message = "Campo requerido")
	private String country;
	
	private boolean receivePaper;
	
	@NotEmpty(message = "No has seleccionado ningún lenguaje de programación")
	private String[] favoriteFrameworks;
	
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the receivePaper
	 */
	public boolean isReceivePaper() {
		return receivePaper;
	}
	/**
	 * @param receivePaper the receivePaper to set
	 */
	public void setReceivePaper(boolean receivePaper) {
		this.receivePaper = receivePaper;
	}
	/**
	 * @return the favoriteFrameworks
	 */
	public String[] getFavoriteFrameworks() {
		return favoriteFrameworks;
	}
	/**
	 * @param favoriteFrameworks the favoriteFrameworks to set
	 */
	public void setFavoriteFrameworks(String[] favoriteFrameworks) {
		this.favoriteFrameworks = favoriteFrameworks;
	}
	
}
