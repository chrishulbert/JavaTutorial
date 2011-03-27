package actions.events;

import actions.base.BaseAction;

public class AttendanceRemove extends BaseAction {
	public String execute() {
		services.removePersonFromEvent(personId, eventId);
		return redirect(String.format("Attendance.action?id=%d", eventId));
	}
	
	int eventId;
	public void setEventId(int value) {eventId = value;}

	int personId;
	public void setPersonId(int value) {personId = value;}
}
