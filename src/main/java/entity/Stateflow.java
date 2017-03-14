package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the stateflow database table.
 * 
 */
@Entity
@NamedQuery(name="Stateflow.findAll", query="SELECT s FROM Stateflow s")
public class Stateflow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Event
	@ManyToOne
	@JoinColumn(name="event")
	private Event event;

	//bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name="currentstate")
	private State currentstate;

	//bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name="nextstate")
	private State nextstate;

	public Stateflow() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public State getCurrentstate() {
		return currentstate;
	}

	public void setCurrentstate(State currentstate) {
		this.currentstate = currentstate;
	}

	public State getNextstate() {
		return nextstate;
	}

	public void setNextstate(State nextstate) {
		this.nextstate = nextstate;
	}


}