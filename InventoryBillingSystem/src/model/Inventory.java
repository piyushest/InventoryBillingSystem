package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the inventory database table.
 * 
 */
@Entity
@NamedQuery(name="Inventory.findAll", query="SELECT i FROM Inventory i")
public class Inventory implements Serializable {
	public Inventory(InventoryPK id, String category, String description,
			String inventorycol, String name, String quantityAvailable, String rate) {
		super();
		this.id = id;
		this.category = category;
		this.description = description;
		this.inventorycol = inventorycol;
		this.name = name;
		this.quantityAvailable = Integer.parseInt(quantityAvailable);
		this.rate = Float.parseFloat(rate);
	}

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InventoryPK id;

	private String category;

	private String description;

	private String inventorycol;

	private String name;

	@Column(name="quantity_available")
	private int quantityAvailable;

	private float rate;

	public Inventory() {
	}

	public InventoryPK getId() {
		return this.id;
	}

	public void setId(InventoryPK id) {
		this.id = id;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInventorycol() {
		return this.inventorycol;
	}

	public void setInventorycol(String inventorycol) {
		this.inventorycol = inventorycol;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantityAvailable() {
		return this.quantityAvailable;
	}

	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public float getRate() {
		return this.rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

}