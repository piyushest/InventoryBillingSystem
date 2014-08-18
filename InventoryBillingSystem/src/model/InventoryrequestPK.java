package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the inventoryrequest database table.
 * 
 */
@Embeddable
public class InventoryrequestPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="request_id")
	private int requestId;

	@Column(name="distributor_id")
	private int distributorId;

	private float price;

	public InventoryrequestPK() {
	}
	public int getRequestId() {
		return this.requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof InventoryrequestPK)) {
			return false;
		}
		InventoryrequestPK castOther = (InventoryrequestPK)other;
		return 
			(this.requestId == castOther.requestId)
			&& (this.distributorId == castOther.distributorId)
			&& (this.price == castOther.price);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.requestId;
		hash = hash * prime + this.distributorId;
		hash = hash * prime + java.lang.Float.floatToIntBits(this.price);
		
		return hash;
	}
}