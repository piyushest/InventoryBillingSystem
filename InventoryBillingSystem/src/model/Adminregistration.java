package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the adminregistration database table.
 * 
 */
@Entity
@NamedQuery(name="Adminregistration.findAll", query="SELECT a FROM Adminregistration a")
public class Adminregistration implements Serializable {
	public Adminregistration(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	private static final long serialVersionUID = 1L;

	@Id
	private int adminid;

	private String name;

	private String password;

	public Adminregistration() {
	}

	public int getAdminid() {
		return this.adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}