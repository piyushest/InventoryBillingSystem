package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the inventory database table.
 * 
 */
@Embeddable
public class InventoryPK implements Serializable {
	public InventoryPK(
String distributorId, String productId) {
		super();
		this.distributorId = Integer.parseInt(distributorId);
		this.productId = Integer.parseInt(productId);
	}

	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="distributor_id")
	private int distributorId;

	@Column(name="product_id")
	private int productId;

	public InventoryPK() {
	}
	public int getDistributorId() {
		return this.distributorId;
	}
	public void setDistributorId(int distributorId) {
		this.distributorId = distributorId;
	}
	public int getProductId() {
		return this.productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof InventoryPK)) {
			return false;
		}
		InventoryPK castOther = (InventoryPK)other;
		return 
			(this.distributorId == castOther.distributorId)
			&& (this.productId == castOther.productId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.distributorId;
		hash = hash * prime + this.productId;
		
		return hash;
	}
}