package View;

import Controller.TaskManager;
import spark.*;

public class PostSubmitEditRoute implements Route {
	private TemplateEngine templateEngine;

	private TaskManager taskManager;

	public PostSubmitEditRoute(TemplateEngine templateEngine, TaskManager taskManager){
		this.templateEngine = templateEngine;
		this.taskManager = taskManager;
	}

	public Object handle(Request request, Response response){
		Session httpSession = request.session();

		int taskId = httpSession.attribute("taskId");
		httpSession.attribute("taskId", null);

		String newData = request.queryParams("data");

		taskManager.alterTask(taskId, newData);

		response.redirect(WebServer.TASKS_URL);
		return null;
	}
}
