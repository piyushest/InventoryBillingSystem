package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the areadistributor database table.
 * 
 */
@Entity
@NamedQuery(name="Areadistributor.findAll", query="SELECT a FROM Areadistributor a")
public class Areadistributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AreadistributorPK id;

	@Column(name="zip_code")
	private int zipCode;

	//bi-directional many-to-one association to Adminregistereddistributor
	@ManyToOne
	@JoinColumn(name="distributor_id")
	private Adminregistereddistributor adminregistereddistributor;

	//bi-directional many-to-one association to Adminretailerregistration
	@ManyToOne
	@JoinColumn(name="reseller_id")
	private Adminretailerregistration adminretailerregistration;

	public Areadistributor() {
	}

	public AreadistributorPK getId() {
		return this.id;
	}

	public void setId(AreadistributorPK id) {
		this.id = id;
	}

	public int getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public Adminregistereddistributor getAdminregistereddistributor() {
		return this.adminregistereddistributor;
	}

	public void setAdminregistereddistributor(Adminregistereddistributor adminregistereddistributor) {
		this.adminregistereddistributor = adminregistereddistributor;
	}

	public Adminretailerregistration getAdminretailerregistration() {
		return this.adminretailerregistration;
	}

	public void setAdminretailerregistration(Adminretailerregistration adminretailerregistration) {
		this.adminretailerregistration = adminretailerregistration;
	}

}