package actions.people;

import actions.base.BaseAction;
import data.*;
import java.util.List;

public class Listing extends BaseAction {

	public String execute() {
		people = services.getPeople();
		return "success";
	}
	
	List<Person> people;
	public List<Person> getPeople() { return people; }
}
