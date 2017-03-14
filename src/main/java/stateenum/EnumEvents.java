/**
 * 
 */
package stateenum;

/**
 * @author The Elite Gentleman
 *
 */
public enum EnumEvents {
	BOARD, PASS_MONEY, RECEIVE_CHANGE, CLICK_COIN_ON_ROOF, 
	GET_OFF, NO_CHANGE, RESOLVE, NO_MONEY;
	
	public String toString() {
		String value;
		switch (this) {
		case BOARD:
			value = "Board";	
			break;
		case PASS_MONEY:
			value = "Waiting for Pay";
			break;
		case RECEIVE_CHANGE:
			value = "Waiting for Change";
			break;
		case CLICK_COIN_ON_ROOF:
			value = "Riding Jeep";
			break;
		case GET_OFF:
			value = "Waiting to Stop";
			break;
		case NO_CHANGE:
			value = "Change Resolution";
			break;
		case RESOLVE:
			value = "Resolve";
			break;
		case NO_MONEY:
			value ="No Money";
			break;
		default:
			value = "Invalid State";
			break;
		}
		return value;
	}

}
