package actions.events;

import actions.base.BaseAction;
import data.*;
import java.util.List;

public class Listing extends BaseAction {
	
	public String execute() {
		events = services.getEvents();
		return "success";
	}
	
	List<Event> events;
	public List<Event> getEvents() { return events; }
}
