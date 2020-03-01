package View;

import Controller.TaskManager;
import spark.*;

import java.util.HashMap;
import java.util.Map;

public class PostCompleteTaskRoute implements Route {
	//TemplateEngine for rendering html pages
	private final TemplateEngine templateEngine;

	//TaskManager for retrieving specific task & marking as done
	private final TaskManager taskManager;

	//Constructor
	public PostCompleteTaskRoute(TemplateEngine templateEngine, TaskManager taskManager){
		this.templateEngine = templateEngine;
		this.taskManager = taskManager;
	}

	//Perform operations specified by http request
	public Object handle(Request request, Response response){
		//Current user's session, stores long-term info
		final Session httpSession = request.session();

		//View Model: stores short-term info to be displayed in html page
		Map<String, Object> vm = new HashMap<String, Object>();

		//unique identifying number of desired task
		int taskId = Integer.parseInt(request.queryParams("taskId"));
		taskManager.completeTask(taskId);

		vm.put("title", "Complete");

		response.redirect(WebServer.HOME_URL);
		return null;
	}
}
