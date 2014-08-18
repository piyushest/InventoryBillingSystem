package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the requestdetails database table.
 * 
 */
@Entity
@Table(name="requestdetails")
@NamedQuery(name="Requestdetail.findAll", query="SELECT r FROM Requestdetail r")
public class Requestdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RequestdetailPK id;

	private float price;

	private int quantity;

	public Requestdetail() {
	}

	public RequestdetailPK getId() {
		return this.id;
	}

	public void setId(RequestdetailPK id) {
		this.id = id;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}