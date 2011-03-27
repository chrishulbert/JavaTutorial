package services;

import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import data.*;
import java.util.List;

// This class is the business services tier in the application.
// @Transactional is needed so that a Hibernate transaction is set up,
//  otherwise updates won't have an affect
@Transactional
public class Services {
	// So Spring can inject the session factory
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory value) {
		sessionFactory = value;
	}

	// Shortcut for sessionFactory.getCurrentSession()
	public Session sess() {
		return sessionFactory.getCurrentSession();
	}

	public Event getEventById(long id) {
		return (Event) sess().load(Event.class, id);
	}

	public Person getPersonById(long id) {
		return (Person) sess().load(Person.class, id);
	}

	public void deleteEventById(long id) {
		sess().delete(getEventById(id));
	}

	public void deletePersonById(long id) {
		sess().delete(getPersonById(id));
	}

	public void createEvent(String name) {
		Event theEvent = new Event();
		theEvent.setName(name);
		sess().save(theEvent);
	}

	public void createPerson(String name) {
		Person p = new Person();
		p.setName(name);
		sess().save(p);
	}

	@SuppressWarnings("unchecked")
	public List<Event> getEvents() {
		return sess().createQuery("from Event").list();
	}

	@SuppressWarnings("unchecked")
	public List<Person> getPeople() {
		return sess().createQuery("from Person").list();
	}

	public void removePersonFromEvent(int personId, int eventId) {
		getEventById(eventId).getPeople().remove(getPersonById(personId));
	}

	public void addPersonToEvent(int personId, int eventId) {
		getEventById(eventId).getPeople().add(getPersonById(personId));
	}
}
