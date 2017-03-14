package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the userstate database table.
 * 
 */
@Entity
@NamedQuery(name="Userstate.findAll", query="SELECT u FROM Userstate u")
public class Userstate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	// private String statecode;
	@ManyToOne
	@JoinColumn(name="statecode")
	private State statecode;
	
	//bi-directional many-to-one association to Rider
	@ManyToOne
	@JoinColumn(name="riderid")
	private Rider rider;

	//bi-directional many-to-one association to Vehicle
	@ManyToOne
	@JoinColumn(name="vehicleid")
	private Vehicle vehicle;

	public Userstate() {
	}
	
	public Userstate(Vehicle vehicle, Rider rider, State state) {
		this.setRider(rider);
		this.setVehicle(vehicle);
		this.setStatecode(state);
	}
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public State getStatecode() {
		return statecode;
	}

	public void setStatecode(State statecode) {
		this.statecode = statecode;
	}

	public Rider getRider() {
		return this.rider;
	}

	public void setRider(Rider rider) {
		this.rider = rider;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}