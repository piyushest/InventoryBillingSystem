package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the distributorlogin database table.
 * 
 */
@Entity
@NamedQuery(name="Distributorlogin.findAll", query="SELECT d FROM Distributorlogin d")
public class Distributorlogin implements Serializable {
	public Distributorlogin(String password, String username) {
		super();
		this.password = password;
		this.username = username;
	}

	public Distributorlogin(int id, String password, String username) {
		super();
		this.id = id;
		this.password = password;
		this.username = username;
	}

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String password;

	private String username;

	public Distributorlogin() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}