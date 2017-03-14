package connectionUtil;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entity.Event;
import entity.Rider;
import entity.Userstate;
import entity.Vehicle;

public class DataUtil {
	public static List select(String queryString){
		Session session = connectionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery(queryString);
		return query.getResultList();
	}
	
	public static Event getEventByCode(String code){
		Session session = connectionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Event where eventcode = :code");
		query.setParameter("code", code);
		Event event = (Event) query.getSingleResult();
		return event;
	}
	
	public static boolean saveUserstate(Userstate userState){
		try{
		Session session = connectionFactory.getSessionFactory().openSession();		  
        session.beginTransaction(); 
        session.save(userState);       
        session.getTransaction().commit();
        return true;
        }catch(Exception E){
        	return false;
        }
	}
	
	public static Rider getRiderbyId(int id){
		Session session = connectionFactory.getSessionFactory().openSession();
		Rider rider = (Rider) session.find(Rider.class, new Integer(id));
		return rider;
	}
	
	public static Vehicle getVehiclebyId(int id){
		Session session = connectionFactory.getSessionFactory().openSession();
		Vehicle vehicle = (Vehicle) session.find(Vehicle.class, new Integer(id));
		return vehicle;
	}
}
