package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the areadistributor database table.
 * 
 */
@Embeddable
public class AreadistributorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="distributor_id", insertable=false, updatable=false)
	private int distributorId;

	@Column(name="reseller_id", insertable=false, updatable=false)
	private int resellerId;

	public AreadistributorPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AreadistributorPK)) {
			return false;
		}
		AreadistributorPK castOther = (AreadistributorPK)other;
		return 
			(this.distributorId == castOther.distributorId)
			&& (this.resellerId == castOther.resellerId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.distributorId;
		hash = hash * prime + this.resellerId;
		
		return hash;
	}
}