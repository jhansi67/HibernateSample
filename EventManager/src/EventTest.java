
import static java.lang.System.out;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import eventmgr.domain.Event;
import eventmgr.domain.Location;
import eventmgr.domain.Speaker;

public class EventTest {
	private static SessionFactory factory = HibernateUtil.getSessionFactory();

	public static void saveEvents( ) {
		Event event = new Event( );
		event.setName("Java Days");
		event.setStartDate( new java.util.Date(108,Calendar.JULY,10) );
		Set<Speaker> setSpeak=new TreeSet();
		Speaker s=new Speaker();
		s.setName("Jhansi");
		s.setTelephone("9963307742");
		Speaker s1=new Speaker();
		s.setName("Reddy");
		s.setTelephone("9963307742");
		setSpeak.add(s);
		setSpeak.add(s1);
		
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(
				"from Location where name=:name");
		query.setParameter("name", "Kasetsart University");
		List list = query.list();
		event.setLocation( (Location)list.get(0) );
		event.setSpeakers(setSpeak);
		
		out.printf("Saving event: %s\nLocation: %s\n",
					event, event.getLocation() );
		session.save( event );
		tx.commit();
		// getCurrentSession creates a session that is bound to a
		// single
		out.println("Event saved");

	}
	/** retrieve some events from the database */
	/*public static void testRetrieve() {
		System.out.println("Retrieving locations...");
		Session session = factory.openSession();
		List list = session.createQuery("from Location").list();
		Transaction tx = (Transaction) session.beginTransaction();

		// print the locations
		for (Object loc : list)
			System.out.println(loc);
		try {
			tx.commit();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		session.close();
		System.out.println("Done retrieving");
	}*/
	public static void testRetrieve( ) {
		System.out.println("Retrieving events...");
		
		Session session = factory.openSession( );
		Transaction tx = session.beginTransaction();
		// get all the events
		Query query = session.createQuery( "from Event" );
		List<Event> list = (List<Event>)query.list( );
		tx.commit();
		//(2) close the session
				session.close( );
	//(1)
		for(Event e : list ) {
			out.printf("%s on %tD\n", e.toString(), e.getStartDate() );
			out.printf("  Location: %s\n", e.getLocation() );
			out.print( "  Speakers:");
			for(Speaker s : e.getSpeakers() ) 
				out.print(" speaker name is-->"+s.getName() );
			out.println();
		}
		//session.close( );
	
	}

	public static void main(String[] args) {
		// recreate the locations because we told Hibernate
		// to recreate the schema each run.
		LocationTest.saveLocations( );
		saveEvents();
		testRetrieve();
		factory.close();
	}
}
