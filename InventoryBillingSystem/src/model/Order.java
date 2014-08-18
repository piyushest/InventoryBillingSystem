package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name="orders")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	public Order(int distributorId, int resellerId) {
		super();
		this.distributorId = distributorId;
		this.resellerId = resellerId;
	}

	public Order(int orderId, int distributorId, int resellerId) {
		super();
		this.orderId = orderId;
		this.distributorId = distributorId;
		this.resellerId = resellerId;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_id")
	private int orderId;

	@Column(name="distributor_id")
	private int distributorId;

	@Column(name="reseller_id")
	private int resellerId;

	//bi-directional one-to-one association to Orderdetail
	@OneToOne(mappedBy="order")
	private Orderdetail orderdetail;

	public Order() {
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getDistributorId() {
		return this.distributorId;
	}

	public void setDistributorId(int distributorId) {
		this.distributorId = distributorId;
	}

	public int getResellerId() {
		return this.resellerId;
	}

	public void setResellerId(int resellerId) {
		this.resellerId = resellerId;
	}

	public Orderdetail getOrderdetail() {
		return this.orderdetail;
	}

	public void setOrderdetail(Orderdetail orderdetail) {
		this.orderdetail = orderdetail;
	}

}