package View;

import Controller.TaskManager;
import spark.*;

import java.util.HashMap;
import java.util.Map;

public class PostTasksRoute implements Route{
	//TemplateEngine for rendering html pages
	private final TemplateEngine templateEngine;

	//TaskManager for retrieving specific tasks
	private final TaskManager taskManager;

	//Constructor
	public PostTasksRoute(TemplateEngine templateEngine, TaskManager taskManager){
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

		vm.put("tasks", taskManager.getTaskList());
		vm.put("inputId", taskId);

		return templateEngine.render(new ModelAndView(vm, "task.ftl"));
	}
}
