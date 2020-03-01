package View;

import Controller.TaskManager;
import spark.*;

import java.util.HashMap;
import java.util.Map;

public class PostCompleteTaskRoute implements Route {
	private final TemplateEngine templateEngine;
	private final TaskManager taskManager;

	public PostCompleteTaskRoute(TemplateEngine templateEngine, TaskManager taskManager){
		this.templateEngine = templateEngine;
		this.taskManager = taskManager;
	}

	public Object handle(Request request, Response response){
		final Session httpSession = request.session();

		Map<String, Object> vm = new HashMap<String, Object>();
		int taskId = Integer.parseInt(request.queryParams("taskId"));
		taskManager.completeTask(taskId);
		vm.put("title", "Complete");

		response.redirect(WebServer.TASKS_URL);
		return null;
	}
}
