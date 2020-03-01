package View;

import Controller.StatsManager;
import Controller.TaskManager;
import spark.*;

import java.util.Map;
import java.util.HashMap;

public class GetHomeRoute implements Route {
	//TemplateEngine for rendering html pages
	private final TemplateEngine templateEngine;

	//StatsManager & TaskManager for calculating progress
	private final StatsManager statsManager;
	private final TaskManager taskManager;

	//Constructor
	public GetHomeRoute(TemplateEngine templateEngine,
	                    TaskManager taskManager, StatsManager statsManager){
		this.templateEngine = templateEngine;
		this.statsManager = statsManager;
		this.taskManager = taskManager;
	}

	//Perform operations specified by http request
	public Object handle(Request request, Response response){
		//Current user's session, stores long-term info
		final Session httpSession = request.session();

		//View Model: stores short-term info to be displayed in html page
		Map<String, Object> vm = new HashMap<String, Object>();

		//Calculating progress
		if(taskManager.getNumTasks() == 0){
			vm.put("percentDone", 1);
		}
		else{
			vm.put("percentDone", (double)(statsManager.getTotalTasks()) /
					(statsManager.getTotalTasks() + taskManager.getNumTasks()));
		}

		vm.put("title", "Home");

		return templateEngine.render(new ModelAndView(vm, "home.ftl"));
	}
}
