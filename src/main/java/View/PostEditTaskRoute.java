package View;

import spark.*;

import java.util.HashMap;
import java.util.Map;

public class PostEditTaskRoute implements Route {
	//TemplateEngine for rendering html pages
	private final TemplateEngine templateEngine;

	//Constructor
	public PostEditTaskRoute(TemplateEngine templateEngine){ this.templateEngine = templateEngine; }

	//Perform operations specified by http request
	public Object handle(Request request, Response response){
		//Current user's session, stores long-term info
		final Session httpSession = request.session();

		//View Model: stores short-term info to be displayed in html page
		Map<String, Object> vm = new HashMap<String, Object>();

		vm.put("title", "Edit");

		response.redirect(WebServer.HOME_URL);
		return null;
	}
}
