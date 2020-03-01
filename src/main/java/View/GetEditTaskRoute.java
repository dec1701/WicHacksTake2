package View;

import Controller.TaskManager;
import Model.Task;
import spark.*;

import java.util.HashMap;
import java.util.Map;

public class GetEditTaskRoute implements Route {
	private final TemplateEngine templateEngine;
	private final TaskManager taskManager;

	public GetEditTaskRoute(TemplateEngine templateEngine, TaskManager taskManager){
		this.templateEngine = templateEngine;
		this.taskManager = taskManager;
	}

	public Object handle(Request request, Response response){
		final Session httpSession = request.session();

		Map<String, Object> vm = new HashMap<>();

		//int taskId = Integer.parseInt(request.queryParams("taskId"));
		//Task currentTask = taskManager.getTask(taskId);

		//vm.put("task", currentTask);

		vm.put("title", "Edit");

		return templateEngine.render(new ModelAndView(vm, "edit.ftl"));
	}
}
