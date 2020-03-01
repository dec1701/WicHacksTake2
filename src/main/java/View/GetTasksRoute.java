package View;

import Controller.TaskManager;
import spark.*;

import java.util.HashMap;
import java.util.Map;

public class GetTasksRoute implements Route {
	private final TemplateEngine templateEngine;
	private static final String VIEW_NAME = "task.ftl";
	private final TaskManager taskManager;

	public GetTasksRoute(TemplateEngine templateEngine, TaskManager taskManager){
		this.templateEngine = templateEngine;
		this.taskManager = taskManager;
	}

	public Object handle(Request request, Response response){
		//final Session httpSession = request.session();

		Map<String, Object> vm = new HashMap<String, Object>();
		//vm.put("tasks", taskManager.getTaskList());
		vm.put("title", "Tasks");

		return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
	}
}
