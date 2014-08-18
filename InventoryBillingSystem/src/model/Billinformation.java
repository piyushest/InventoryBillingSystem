package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the billinformation database table.
 * 
 */
@Entity
@NamedQuery(name="Billinformation.findAll", query="SELECT b FROM Billinformation b")
public class Billinformation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="bill_no")
	private int billNo;

	@Column(name="distributor_id")
	private int distributorId;

	@Column(name="order_id")
	private int orderId;

	public Billinformation() {
	}

	public int getBillNo() {
		return this.billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public int getDistributorId() {
		return this.distributorId;
	}

	public void setDistributorId(int distributorId) {
		this.distributorId = distributorId;
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

}