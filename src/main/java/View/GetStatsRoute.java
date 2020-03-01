package View;

import Controller.StatsManager;
import Controller.TaskManager;
import org.eclipse.jetty.websocket.common.io.AbstractWebSocketConnection;
import spark.*;

import java.util.Map;


import java.util.HashMap;

public class GetStatsRoute implements Route {
	//TaskManager for retrieving specific task
	private final TemplateEngine templateEngine;

	//StatsManager & TaskManager for calculating progress
	private final StatsManager statsManager;
	private final TaskManager taskManager;

	//Constructor
	public GetStatsRoute(TemplateEngine templateEngine, StatsManager statsManager, TaskManager taskManager){
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

		vm.put("tasksDone", statsManager.getTotalTasks());
		vm.put("tasksToDo", taskManager.getNumTasks());
		vm.put("title", "Stats");

		return templateEngine.render(new ModelAndView(vm, "stats.ftl"));
	}
}
