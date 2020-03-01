package View;

import Controller.TaskManager;
import spark.*;

import java.util.HashMap;
import java.util.Map;

public class PostAddTaskRoute implements Route {

	private final TemplateEngine templateEngine;
	private final TaskManager taskManager;

	public PostAddTaskRoute(TemplateEngine templateEngine, TaskManager taskManager){
		this.templateEngine = templateEngine;
		this.taskManager = taskManager;
	}

	public Object handle(Request request, Response response){
		final Session httpSession = request.session();

		Map<String, Object> vm = new HashMap<String, Object>();

		taskManager.addTask(request.queryParams("desc"));

		vm.put("title", "Add");

		response.redirect(WebServer.HOME_URL);
		return null;
	}
}
