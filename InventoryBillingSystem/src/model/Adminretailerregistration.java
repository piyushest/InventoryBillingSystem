package model;

import java.io.Serializable;

import javax.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


/**
 * The persistent class for the adminretailerregistration database table.
 * 
 */
@Entity
@NamedQuery(name="Adminretailerregistration.findAll", query="SELECT a FROM Adminretailerregistration a")
public class Adminretailerregistration implements Serializable {
	
	public Adminretailerregistration(String area, String memberSince,
			String name, String statusoffees, String subscriptionFees,
			String zipCode) throws ParseException {
		super();
		this.area = area;
		this.memberSince =new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(memberSince);
		this.name = name;
		this.statusoffees = statusoffees;
		this.subscriptionFees = Float.parseFloat(subscriptionFees);
		this.zipCode = Integer.parseInt(zipCode);
	}

	public Adminretailerregistration(String resellerId, String area,
			String memberSince, String name, String statusoffees,
			String subscriptionFees,String zipCode) throws ParseException {
		super();
		this.resellerId = Integer.parseInt(resellerId);
		this.area = area;
		this.memberSince =new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(memberSince);
		this.name = name;
		this.statusoffees = statusoffees;
		this.subscriptionFees = Float.parseFloat(subscriptionFees);
		this.zipCode = Integer.parseInt(zipCode);
	}

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="reseller_id")
	private int resellerId;

	private String area;

	@Temporal(TemporalType.DATE)
	@Column(name="member_since")
	private Date memberSince;

	private String name;

	private String statusoffees;

	@Column(name="subscription_fees")
	private float subscriptionFees;

	@Column(name="zip_code")
	private int zipCode;

	//bi-directional many-to-one association to Areadistributor
	@OneToMany(mappedBy="adminretailerregistration")
	private List<Areadistributor> areadistributors;

	public Adminretailerregistration() {
	}

	public int getResellerId() {
		return this.resellerId;
	}

	public void setResellerId(int resellerId) {
		this.resellerId = resellerId;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Date getMemberSince() {
		return this.memberSince;
	}

	public void setMemberSince(Date memberSince) {
		this.memberSince = memberSince;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatusoffees() {
		return this.statusoffees;
	}

	public void setStatusoffees(String statusoffees) {
		this.statusoffees = statusoffees;
	}

	public float getSubscriptionFees() {
		return this.subscriptionFees;
	}

	public void setSubscriptionFees(float subscriptionFees) {
		this.subscriptionFees = subscriptionFees;
	}

	public int getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public List<Areadistributor> getAreadistributors() {
		return this.areadistributors;
	}

	public void setAreadistributors(List<Areadistributor> areadistributors) {
		this.areadistributors = areadistributors;
	}

	public Areadistributor addAreadistributor(Areadistributor areadistributor) {
		getAreadistributors().add(areadistributor);
		areadistributor.setAdminretailerregistration(this);

		return areadistributor;
	}

	public Areadistributor removeAreadistributor(Areadistributor areadistributor) {
		getAreadistributors().remove(areadistributor);
		areadistributor.setAdminretailerregistration(null);

		return areadistributor;
	}

}