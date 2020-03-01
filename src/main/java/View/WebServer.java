package View;

import static spark.Spark.*;

import Controller.TaskManager;
import spark.TemplateEngine;
import com.google.gson.Gson;

import static spark.Spark.staticFileLocation;

public class WebServer {
	//URLs
	public static final String HOME_URL = "/";
	public static final String SETTINGS_URL = "/Settings";
	public static final String STATS_URL = "/Stats";
	public static final String TASKS_URL = "/Tasks";

	//utils
	private final TemplateEngine templateEngine;
	private final Gson gson;

	//Controller classes
	private final TaskManager taskManager;


	public WebServer(final TemplateEngine templateEngine, final Gson gson, TaskManager taskManager){
		//utils
		this.templateEngine = templateEngine;
		this.gson = gson;

		//Controller classes
		this.taskManager = taskManager;
	}

	public void initialize(){
		// Configuration to serve static files
		staticFileLocation("/public");

		get(HOME_URL, new GetHomeRoute(templateEngine));
		get(SETTINGS_URL, new GetSettingsRoute(templateEngine));
		get(STATS_URL, new GetStatsRoute(templateEngine));
		get(TASKS_URL, new GetTasksRoute(templateEngine));
	}
}
