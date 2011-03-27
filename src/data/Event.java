package data;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="events")
public class Event {
  @Id @GeneratedValue
  Long id;
  public Long getId() {return id;}
  public void setId(Long id) {this.id = id;}
	
  String name;
  public String getName() {return name;}
  public void setName(String value) {name = value;}

  @ManyToMany
  @JoinTable(
      name="event_person",
      joinColumns=@JoinColumn(name="event_id"),
      inverseJoinColumns=@JoinColumn(name="person_id")
  )
  Set<Person> people;
  public void setPeople(Set<Person> people) {this.people = people;}
  public Set<Person> getPeople() {return people;}
}
