package View;

import Controller.TaskManager;
import Model.Task;
import spark.*;

import java.util.HashMap;
import java.util.Map;

public class GetEditTaskRoute implements Route {
	//TemplateEngine for rendering html pages
	private final TemplateEngine templateEngine;

	//TaskManager for retrieving specific task
	private final TaskManager taskManager;

	//Constructor
	public GetEditTaskRoute(TemplateEngine templateEngine, TaskManager taskManager){
		this.templateEngine = templateEngine;
		this.taskManager = taskManager;
	}

	//Perform operations specified by http request
	public Object handle(Request request, Response response){
		//Current user's session, stores long-term info
		final Session httpSession = request.session();

		//View Model: stores short-term info to be displayed in html page
		Map<String, Object> vm = new HashMap<>();

		//unique identifying number of desired task
		int taskId = Integer.parseInt(request.queryParams("taskId"));
		Task currentTask = taskManager.getTask(taskId);

		vm.put("task", currentTask);

		return templateEngine.render(new ModelAndView(vm, "edit.ftl"));
	}
}
