package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rider database table.
 * 
 */
@Entity
@NamedQuery(name="Rider.findAll", query="SELECT r FROM Rider r")
public class Rider implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String description;


	public Rider() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}