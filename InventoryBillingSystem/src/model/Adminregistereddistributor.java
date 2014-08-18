package model;

import java.io.Serializable;

import javax.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


/**
 * The persistent class for the adminregistereddistributor database table.
 * 
 */
@Entity
@NamedQuery(name="Adminregistereddistributor.findAll", query="SELECT a FROM Adminregistereddistributor a")
public class Adminregistereddistributor implements Serializable {
	
	public Adminregistereddistributor(String distributorId, String membersince,
			String name, String phone, String statusoffees,
			String subscriptionfees, String zipcode) throws ParseException {
		super();
		this.distributorId = Integer.parseInt(distributorId);
		this.membersince = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(membersince);
		this.name = name;
		this.phone = Integer.parseInt(phone);
		this.statusoffees = statusoffees;
		this.subscriptionfees = Float.parseFloat(subscriptionfees);
		this.zipcode = Integer.parseInt(zipcode);
	}

	public Adminregistereddistributor(String membersince, String name, String phone,
			String statusoffees, String subscriptionfees, String zipcode) throws ParseException {
		super();
		this.membersince = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(membersince);
		this.name = name;
		this.phone = Integer.parseInt(phone);
		this.statusoffees = statusoffees;
		this.subscriptionfees = Float.parseFloat(subscriptionfees);
		this.zipcode = Integer.parseInt(zipcode);
	}

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="distributor_id")
	private int distributorId;

	@Temporal(TemporalType.DATE)
	private Date membersince;

	private String name;

	private int phone;

	private String statusoffees;

	private float subscriptionfees;

	private int zipcode;

	//bi-directional many-to-one association to Areadistributor
	@OneToMany(mappedBy="adminregistereddistributor")
	private List<Areadistributor> areadistributors;

	public Adminregistereddistributor() {
	}

	public int getDistributorId() {
		return this.distributorId;
	}

	public void setDistributorId(int distributorId) {
		this.distributorId = distributorId;
	}

	public Date getMembersince() {
		return this.membersince;
	}

	public void setMembersince(Date membersince) {
		this.membersince = membersince;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getStatusoffees() {
		return this.statusoffees;
	}

	public void setStatusoffees(String statusoffees) {
		this.statusoffees = statusoffees;
	}

	public float getSubscriptionfees() {
		return this.subscriptionfees;
	}

	public void setSubscriptionfees(float subscriptionfees) {
		this.subscriptionfees = subscriptionfees;
	}

	public int getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public List<Areadistributor> getAreadistributors() {
		return this.areadistributors;
	}

	public void setAreadistributors(List<Areadistributor> areadistributors) {
		this.areadistributors = areadistributors;
	}

	public Areadistributor addAreadistributor(Areadistributor areadistributor) {
		getAreadistributors().add(areadistributor);
		areadistributor.setAdminregistereddistributor(this);

		return areadistributor;
	}

	public Areadistributor removeAreadistributor(Areadistributor areadistributor) {
		getAreadistributors().remove(areadistributor);
		areadistributor.setAdminregistereddistributor(null);

		return areadistributor;
	}

}