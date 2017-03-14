/**
 * 
 */
package stateenum;

/**
 * @author The Elite Gentleman
 *
 */
public enum EnumStates {
	WAITING_FOR_JEEP, WAITING_FOR_PAY, WAITING_FOR_CHANGE, RIDING_JEEP, 
	WAITING_TO_STOP, CHANGE_RESOLUTION, END, INVALID_STATE;
	public String toString() {
		String value;
		switch (this) {
		case WAITING_FOR_JEEP:
			value = "Waiting for Jeep";	
			break;
		case WAITING_FOR_PAY:
			value = "Waiting for Pay";
			break;
		case WAITING_FOR_CHANGE:
			value = "Waiting for Change";
			break;
		case RIDING_JEEP:
			value = "Riding Jeep";
			break;
		case WAITING_TO_STOP:
			value = "Waiting to Stop";
			break;
		case CHANGE_RESOLUTION:
			value = "Change Resolution";
			break;
		case END:
			value= "End";
			break;
		default:
			value = "Invalid State";
			break;
		}
		return value;
	}

}
