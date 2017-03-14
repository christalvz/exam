package statemachine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import entity.Event;
import entity.State;
import entity.Stateflow;
import stateenum.EnumEvents;
import stateenum.EnumStates;

public class StatesMachineContainer{
	List<StatesEvents> list = new ArrayList<StatesEvents>();
	List<State> state = null;
	private static final Logger LOGGER = Logger.getLogger(StatesMachineContainer.class.getName());
	public void addState(StatesEvents stateEvent){
		LOGGER.info("Start addState");
		list.add(stateEvent);
		LOGGER.info("End addState");
		
	}
	
	public void addState(List<State> state){
		LOGGER.info("Start addState");
		state.addAll(state);
		LOGGER.info("End addState");
	}
	
	public List<StatesEvents> getStateList(){
		return list;
	}
	
	protected EnumStates nextState(EnumStates cur, EnumEvents event){
		LOGGER.info("Start nextState");
		Iterator<StatesEvents> iterator = list.iterator();
		EnumStates returnVal = null;
		while(iterator.hasNext()){
			StatesEvents val = iterator.next();
			if(val.getEvent().equals(event) && cur.equals(val.fromState)){
				returnVal = val.getToState();
			}
		}
		if(returnVal == null){
			returnVal = EnumStates.INVALID_STATE;
		}
		LOGGER.info("End nextState");
		return returnVal;
	}
	
	protected State nextState(List<Stateflow> flow, State cur, Event event){
		LOGGER.info("Start nextState");
		Iterator<Stateflow> iterator = flow.iterator();
		State returnVal = null;
		while(iterator.hasNext()){
			Stateflow val = iterator.next();
			LOGGER.info(val.getEvent().getEventcode().equals(event.getEventcode()) + "val.getEvent().equals(event)");
			LOGGER.info(cur.equals(val.getCurrentstate()) + "cur.equals(val.getCurrentstate())");
			if(val.getEvent().getEventcode().equals(event.getEventcode()) && cur.equals(val.getCurrentstate())){
				returnVal = val.getNextstate();
			}
		}
		if(returnVal == null){
			LOGGER.info("Invalid State");
		}
		LOGGER.info("End nextState");
		return returnVal;
	}
}