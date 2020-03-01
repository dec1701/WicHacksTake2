package View;

import Controller.TaskManager;
import spark.*;

import java.util.HashMap;
import java.util.Map;

public class PostAddTaskRoute implements Route {
	//TemplateEngine for rendering html pages
	private final TemplateEngine templateEngine;

	//TaskManager for adding task
	private final TaskManager taskManager;

	//Constructor
	public PostAddTaskRoute(TemplateEngine templateEngine, TaskManager taskManager){
		this.templateEngine = templateEngine;
		this.taskManager = taskManager;
	}

	//Perform operations specified by http request
	public Object handle(Request request, Response response){
		//Current user's session, stores long-term info
		final Session httpSession = request.session();

		//View Model: stores short-term info to be displayed in html page
		Map<String, Object> vm = new HashMap<String, Object>();

		//Adding new Task to TaskManager
		taskManager.addTask(request.queryParams("desc"), Integer.parseInt(request.queryParams("stars")));

		vm.put("title", "Add");

		response.redirect(WebServer.HOME_URL);
		return null;
	}
}
