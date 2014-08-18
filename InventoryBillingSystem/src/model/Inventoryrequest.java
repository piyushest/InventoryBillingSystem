package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the inventoryrequest database table.
 * 
 */
@Entity
@NamedQuery(name="Inventoryrequest.findAll", query="SELECT i FROM Inventoryrequest i")
public class Inventoryrequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InventoryrequestPK id;

	private String description;

	public Inventoryrequest() {
	}

	public InventoryrequestPK getId() {
		return this.id;
	}

	public void setId(InventoryrequestPK id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}