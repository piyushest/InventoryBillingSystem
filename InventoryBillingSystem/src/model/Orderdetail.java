package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the orderdetails database table.
 * 
 */
@Entity
@Table(name="orderdetails")
@NamedQuery(name="Orderdetail.findAll", query="SELECT o FROM Orderdetail o")
public class Orderdetail implements Serializable {
	public Orderdetail(int orderId, String name, int totalPrice) {
		super();
		this.orderId = orderId;
		this.name = name;
		this.totalPrice = totalPrice;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_id")
	private int orderId;

	private String name;

	@Column(name="total_price")
	private int totalPrice;

	//bi-directional one-to-one association to Order
	@OneToOne
	@PrimaryKeyJoinColumn(name="order_id")
	private Order order;

	public Orderdetail() {
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}