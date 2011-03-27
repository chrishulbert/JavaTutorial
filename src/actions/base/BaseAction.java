package actions.base;

import services.Services;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	// So that spring can inject the business singleton
	protected Services services;
	public void setServices(Services value) {
		services=value;
	}
	
	// For redirect results
	protected String redirectUrl;
	public String getRedirectUrl() {
		return redirectUrl;
	}
	public String redirect(String to) {
		redirectUrl = to;
		return "redirect";
	}
}
