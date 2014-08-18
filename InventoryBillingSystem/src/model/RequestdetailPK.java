package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the requestdetails database table.
 * 
 */
@Embeddable
public class RequestdetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="request_id")
	private int requestId;

	@Column(name="product_id")
	private int productId;

	public RequestdetailPK() {
	}
	public int getRequestId() {
		return this.requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
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
		if (!(other instanceof RequestdetailPK)) {
			return false;
		}
		RequestdetailPK castOther = (RequestdetailPK)other;
		return 
			(this.requestId == castOther.requestId)
			&& (this.productId == castOther.productId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.requestId;
		hash = hash * prime + this.productId;
		
		return hash;
	}
}