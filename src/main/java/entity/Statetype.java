package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the statetype database table.
 * 
 */
@Entity
@NamedQuery(name="Statetype.findAll", query="SELECT s FROM Statetype s")
public class Statetype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String statetype;

	private String description;

	//bi-directional many-to-one association to State
	@OneToMany(mappedBy="statetype")
	private List<State> stateType;

	public Statetype() {
	}

	public String getStatetype() {
		return this.statetype;
	}

	public void setStatetype(String statetype) {
		this.statetype = statetype;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<State> getStateType() {
		return this.stateType;
	}

	public void setStateType(List<State> states) {
		this.stateType = states;
	}

	public State addStateType(State state) {
		getStateType().add(state);
		state.setStatetype(this);

		return state;
	}

	public State removeStateType(State state) {
		getStateType().remove(state);
		state.setStatetype(null);

		return state;
	}

}