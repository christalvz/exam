package statemachine;

import java.util.List;
import java.util.logging.Logger;

import entity.Event;
import entity.State;
import entity.Stateflow;
import stateenum.EnumEvents;
import stateenum.EnumStates;

public class StateMachine extends StatesMachineContainer{
	StatesEvents tempState = null;
	EnumStates curState = null;
	State currentState = null;
	List<Stateflow> flow= null;
	private static final Logger LOGGER = Logger.getLogger(StatesMachineContainer.class.getName());

	public StateMachine(List<Stateflow> flow){
		LOGGER.info("StateMachine Constructor");
		if(flow != null || flow.size()>0){
			for(Stateflow val: flow){ 
				if(val.getCurrentstate().getStatetype() != null && val.getCurrentstate().getStatetype().getStatetype().equals("I")){
					this.currentState = val.getCurrentstate();
				}
			}
		}
		this.flow = flow;
	}
	
	public StateMachine(EnumStates init){
		this.curState = init;
	}
	
	public void initialState(EnumStates init){
		curState = init;
	}
	public State currentState(){
		return this.currentState;
	}
	public EnumStates nextState(EnumEvents event){
		LOGGER.info("Start nextState");
		EnumStates returnVal ;
		if(!nextState(curState, event).equals(EnumStates.INVALID_STATE)){
			returnVal = nextState(curState, event);
			tempState = new StatesEvents(curState, returnVal, event);
			curState=returnVal;
			LOGGER.info(tempState.getFromState().toString() + " " + tempState.getEvent().toString() + " " + tempState.getToState().toString());
		}else{
			returnVal = EnumStates.INVALID_STATE;
			LOGGER.info(returnVal.toString());
		}
		LOGGER.info("End nextState");
		return returnVal;
	}
	
	public State nextState(Event event){
		LOGGER.info("Start nextState");
		State returnVal = null;
		if(nextState(flow, currentState, event)!= null){
			returnVal = nextState(flow, currentState, event);
			currentState= returnVal;			
			LOGGER.info("CUrrent State ::::: " + currentState.getDescription());
		}else{

			LOGGER.info(returnVal.toString());
		}
		LOGGER.info("End nextState");
		return returnVal;
	}
}
