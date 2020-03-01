package View;

import Controller.StatsManager;
import Controller.TaskManager;
import org.eclipse.jetty.websocket.common.io.AbstractWebSocketConnection;
import spark.*;

import java.util.Map;


import java.util.HashMap;

public class GetStatsRoute implements Route {

	private final TemplateEngine templateEngine;
	private final StatsManager statsManager;
	private final TaskManager taskManager;

	public GetStatsRoute(TemplateEngine templateEngine, StatsManager statsManager, TaskManager taskManager){
		this.templateEngine = templateEngine;
		this.statsManager = statsManager;
		this.taskManager = taskManager;
	}

	public Object handle(Request request, Response response){
		final Session httpSession = request.session();

		Map<String, Object> vm = new HashMap<String, Object>();
		vm.put("tasksDone", statsManager.getTotalTasks());
		vm.put("tasksToDo", taskManager.getNumTasks());
		vm.put("title", "Stats");

		return templateEngine.render(new ModelAndView(vm, "stats.ftl"));
	}
}
