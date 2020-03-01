package View;

import Controller.TaskManager;
import Model.Task;
import spark.*;

import java.util.HashMap;
import java.util.Map;

public class PostEditTaskRoute implements Route {
	//TemplateEngine for rendering html pages
	private final TemplateEngine templateEngine;
	private final TaskManager taskManager;


	public PostEditTaskRoute(TemplateEngine templateEngine, TaskManager taskManager){
		this.templateEngine = templateEngine;
		this.taskManager = taskManager;
	}

	//Perform operations specified by http request
	public Object handle(Request request, Response response){
		//Current user's session, stores long-term info
		final Session httpSession = request.session();

		int taskId = Integer.parseInt(request.queryParams("taskId"));

		httpSession.attribute("taskId", taskId);

		String data = request.queryParams("data");

		//View Model: stores short-term info to be displayed in html page
		Map<String, Object> vm = new HashMap<>();

		vm.put("title", "Edit");

		return templateEngine.render(new ModelAndView(vm, "edit.ftl"));
	}
}
