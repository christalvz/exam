

import java.util.List;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import connectionUtil.DataUtil;
import connectionUtil.connectionFactory;
import controller.StateMachineController;
import entity.Rider;
import entity.State;
import entity.Stateflow;
import entity.Statetype;
import entity.Vehicle;
import junit.framework.Assert;
import stateenum.EnumEvents;
import stateenum.EnumStates;
import statemachine.StateMachine;
import statemachine.StatesEvents;
import statemachine.StatesMachineContainer;

/**
 * Unit test for simple App.
 */
public class AppTest {
		private StateMachine st = null;
		
	    @Before
	    public void runBeforeTestMethod() {
	    	st = new StateMachine(EnumStates.WAITING_FOR_JEEP);
	    	// initial state;
	    	// st.initialState(EnumStates.WAITING_FOR_JEEP);
	    	
	    	// set states;
	    	st.addState(new StatesEvents(EnumStates.WAITING_FOR_JEEP, EnumStates.WAITING_FOR_PAY, EnumEvents.BOARD));
	    	st.addState(new StatesEvents(EnumStates.WAITING_FOR_PAY, EnumStates.WAITING_FOR_CHANGE, EnumEvents.PASS_MONEY));
	        st.addState(new StatesEvents(EnumStates.WAITING_FOR_PAY, EnumStates.WAITING_TO_STOP, EnumEvents.NO_MONEY));
	        st.addState(new StatesEvents(EnumStates.WAITING_FOR_CHANGE, EnumStates.RIDING_JEEP, EnumEvents.RECEIVE_CHANGE));
	        st.addState(new StatesEvents(EnumStates.WAITING_FOR_CHANGE, EnumStates.CHANGE_RESOLUTION, EnumEvents.NO_CHANGE));
	        st.addState(new StatesEvents(EnumStates.CHANGE_RESOLUTION, EnumStates.WAITING_TO_STOP, EnumEvents.RESOLVE));
	        st.addState(new StatesEvents(EnumStates.RIDING_JEEP, EnumStates.WAITING_TO_STOP, EnumEvents.CLICK_COIN_ON_ROOF));
	        st.addState(new StatesEvents(EnumStates.WAITING_TO_STOP, EnumStates.END, EnumEvents.GET_OFF));
	     
	    }

	    @Test
	    public void test_method_1() {
	    	st.nextState(EnumEvents.BOARD);
	    	Assert.assertEquals(EnumStates.INVALID_STATE,st.nextState(EnumEvents.RECEIVE_CHANGE));
	    	st.nextState(EnumEvents.NO_MONEY);
	    	
	    }
	    
	    @Test
	    public void testConnection(){
	    	Session session = connectionFactory.getSessionFactory().openSession();
	    	Assert.assertTrue(session.isConnected());
	    }
	    
	    @Test 
	    public void testStateMachine(){
	    	Rider rider = DataUtil.getRiderbyId(1);
	    	Vehicle vehicle = DataUtil.getVehiclebyId(1);
	    	StateMachineController controller = new StateMachineController(rider,vehicle );
	    	Assert.assertTrue(controller.nextEvent(DataUtil.getEventByCode("BOARD")));
	    	Assert.assertTrue(controller.nextEvent(DataUtil.getEventByCode("NO_MONEY")));
	    	Assert.assertTrue(controller.nextEvent(DataUtil.getEventByCode("GET_OFF")));
	    	
	    	Assert.assertTrue(controller.nextEvent(DataUtil.getEventByCode("BOARD")));
	    	Assert.assertTrue(controller.nextEvent(DataUtil.getEventByCode("PASS_MONEY")));
	    	Assert.assertTrue(controller.nextEvent(DataUtil.getEventByCode("RECEIVE_CHANGE")));
	    	Assert.assertTrue(controller.nextEvent(DataUtil.getEventByCode("CLICK_COIN_ON_ROOF")));
	    	Assert.assertTrue(controller.nextEvent(DataUtil.getEventByCode("GET_OFF")));
	    	
	    	
	    	
	    	
	    }
}
