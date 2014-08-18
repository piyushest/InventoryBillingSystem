package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the orderpricedetails database table.
 * 
 */
@Entity
@Table(name="orderpricedetails")
@NamedQuery(name="Orderpricedetail.findAll", query="SELECT o FROM Orderpricedetail o")
public class Orderpricedetail implements Serializable {
	public Orderpricedetail(OrderpricedetailPK id, int distributorId,
			float price, int quantity) {
		super();
		this.id = id;
		this.distributorId = distributorId;
		this.price = price;
		this.quantity = quantity;
	}

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderpricedetailPK id;

	@Column(name="distributor_id")
	private int distributorId;

	private float price;

	private int quantity;

	public Orderpricedetail() {
	}

	public OrderpricedetailPK getId() {
		return this.id;
	}

	public void setId(OrderpricedetailPK id) {
		this.id = id;
	}

	public int getDistributorId() {
		return this.distributorId;
	}

	public void setDistributorId(int distributorId) {
		this.distributorId = distributorId;
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