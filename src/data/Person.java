package data;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="people")
public class Person {
  @Id @GeneratedValue
  Long id;
  public Long getId() {return id;}
  public void setId(Long id) {this.id = id;}

  String name;
  public String getName() {return name;}
  public void setName(String name) {this.name = name;}

  @ManyToMany
  @JoinTable(
      name="event_person",
      joinColumns=@JoinColumn(name="person_id"),
      inverseJoinColumns=@JoinColumn(name="event_id")
  )
  Set<Event> events;
  public void setEvents(Set<Event> events) {this.events = events;}
  public Set<Event> getEvents() {return events;}
}
