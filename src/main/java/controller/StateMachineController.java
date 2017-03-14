package controller;

import java.util.List;

import connectionUtil.DataUtil;
import entity.Event;
import entity.Rider;
import entity.State;
import entity.Stateflow;
import entity.Userstate;
import entity.Vehicle;
import statemachine.StateMachine;

public class StateMachineController {
	private StateMachine st = null;
	Rider rider = null;
	Vehicle vehicle = null;
	public StateMachineController(Rider rider, Vehicle vehicle){
		this.rider = rider;
		this.vehicle = vehicle;
		List<Stateflow> states = DataUtil.select("from Stateflow");
    	st = new StateMachine(states);  
		Userstate usrState = new Userstate(vehicle, rider, st.currentState());
    	DataUtil.saveUserstate(usrState);
	}
	
	public boolean nextEvent(Event event){
		@SuppressWarnings("unchecked")    		
    	State state = st.nextState(event);
    	Userstate usrState = new Userstate(vehicle, rider, state);
    	return DataUtil.saveUserstate(usrState);
	}
}
