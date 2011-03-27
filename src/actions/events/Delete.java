package actions.events;

import data.Event;
import actions.base.BaseAction;

public class Delete extends BaseAction {

	public String execute() {
		if (isPostBack) {
			services.deleteEventById(id);
			return redirect("Listing.action");
		}
		return "success";
	}

	int id;
	public void setId(int value) {id = value;}
	public int getId() {return id;	}

	boolean isPostBack;
	public void setIsPostBack(boolean value) {isPostBack = value;}

	Event getEvent() {return services.getEventById(id);	}
	public String getEventName() {return getEvent().getName();}
}
