package statemachine;

import stateenum.EnumEvents;
import stateenum.EnumStates;

public class StatesEvents{
	EnumStates fromState;
	EnumStates toState;
	EnumEvents event;
	
	public StatesEvents(EnumStates fromState,	EnumStates toState,	EnumEvents event){
		this.fromState = fromState;
		this.toState = toState;
		this.event = event;
	}
	
	
	
	public void fromState(EnumStates val){
		fromState=val;
	}
	
	public EnumStates getFromState() {
		return fromState;
	}

	public EnumStates getToState() {
		return toState;
	}

	public EnumEvents getEvent() {
		return event;
	}

	public void toState(EnumStates val){
		toState= val;
	}
	public void event(EnumEvents val){
		event = val;
	}
}
