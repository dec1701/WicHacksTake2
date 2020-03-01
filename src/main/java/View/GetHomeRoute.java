package View;

import Controller.StatsManager;
import Controller.TaskManager;
import spark.*;

import java.util.Map;
import java.util.HashMap;

public class GetHomeRoute implements Route {

	private final TemplateEngine templateEngine;
	private final StatsManager statsManager;
	private final TaskManager taskManager;

	public GetHomeRoute(TemplateEngine templateEngine,
	                    TaskManager taskManager, StatsManager statsManager){
		this.templateEngine = templateEngine;
		this.statsManager = statsManager;
		this.taskManager = taskManager;
	}

	public Object handle(Request request, Response response){
		final Session httpSession = request.session();

		Map<String, Object> vm = new HashMap<String, Object>();

		TaskManager.STATUS status = taskManager.getStatus();

		String viewName = "";

		switch (status){

			case NONE:
				viewName = "home1.ftl";
				break;

			case SOME:
				viewName = "home2.ftl";
				break;

			case ALL:
				viewName = "home3.ftl";
				break;
		}

		vm.put("title", "Home");

		return templateEngine.render(new ModelAndView(vm, viewName));
	}
}
