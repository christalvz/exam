package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the state database table.
 * 
 */
@Entity
@NamedQuery(name="State.findAll", query="SELECT s FROM State s")
public class State implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String statecode;

	private String description;

	//bi-directional many-to-one association to Statetype
	@ManyToOne
	@JoinColumn(name="statetype")
	private Statetype statetype;

	public State() {
	}

	public String getStatecode() {
		return this.statecode;
	}

	public void setStatecode(String statecode) {
		this.statecode = statecode;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Statetype getStatetype() {
		return statetype;
	}

	public void setStatetype(Statetype statetype) {
		this.statetype = statetype;
	}
}