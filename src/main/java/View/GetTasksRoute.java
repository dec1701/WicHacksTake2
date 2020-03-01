package View;

import Controller.TaskManager;
import spark.*;

import java.util.HashMap;
import java.util.Map;

public class GetTasksRoute implements Route {
	//TemplateEngine for rendering html pages
	private final TemplateEngine templateEngine;

	//template html file
	private static final String VIEW_NAME = "task.ftl";

	//TaskManager for retrieving specific tasks
	private final TaskManager taskManager;

	//Constructor
	public GetTasksRoute(TemplateEngine templateEngine, TaskManager taskManager){
		this.templateEngine = templateEngine;
		this.taskManager = taskManager;
	}

	//Perform operations specified by http request
	public Object handle(Request request, Response response){
		final Session httpSession = request.session();

		httpSession.attribute("taskId", null);

		//View Model: stores short-term info to be displayed in html page
		Map<String, Object> vm = new HashMap<String, Object>();
		vm.put("tasks", taskManager.getTaskList());
		vm.put("inputId", -1);

		return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
	}
}
