package View;

import Controller.TaskManager;
import Model.Task;
import spark.*;

import java.util.HashMap;
import java.util.Map;

public class PostEditTaskRoute implements Route {

	private final TemplateEngine templateEngine;
	private final TaskManager taskManager;

	public PostEditTaskRoute(TemplateEngine templateEngine, TaskManager taskManager){
		this.templateEngine = templateEngine;
		this.taskManager = taskManager;
	}

	public Object handle(Request request, Response response){
		final Session httpSession = request.session();

		int taskId = Integer.parseInt(request.queryParams("taskId"));

		String data = request.queryParams("data");

		taskManager.alterTask(taskId, data);

		Map<String, Object> vm = new HashMap<String, Object>();
		vm.put("title", "Edit");

		response.redirect(WebServer.TASKS_URL);
		return null;
	}
}
