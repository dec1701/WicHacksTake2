package View;

import static spark.Spark.*;

import Controller.StatsManager;
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
	public static final String ADD_TASK_URL = "/AddTask";
	public static final String COMPLETE_TASK_URL = "/CompleteTask";
	public static final String EDIT_TASK_URL = "/EditTask";
	public static final String REMOVE_TASK_URL = "/RemoveTask";


	//utils
	private final TemplateEngine templateEngine;
	private final Gson gson;

	//Controller classes
	private final TaskManager taskManager;
	private final StatsManager statsManager;


	public WebServer(final TemplateEngine templateEngine, final Gson gson, TaskManager taskManager,
	                 StatsManager statsManager){
		//utils
		this.templateEngine = templateEngine;
		this.gson = gson;

		//Controller classes
		this.taskManager = taskManager;
		taskManager.addTask("Buy Groceries");
		taskManager.addTask("Do Laundry");
		taskManager.addTask("???");
		taskManager.addTask("Profit.");
		this.statsManager = statsManager;
	}

	public void initialize(){
		// Configuration to serve static files
		staticFileLocation("/public");

		get(HOME_URL, new GetHomeRoute(templateEngine, taskManager, statsManager));
		get(SETTINGS_URL, new GetSettingsRoute(templateEngine));
		get(STATS_URL, new GetStatsRoute(templateEngine, statsManager, taskManager));
		get(TASKS_URL, new GetTasksRoute(templateEngine, taskManager));
		post(ADD_TASK_URL, new PostAddTaskRoute(templateEngine, taskManager));
		post(COMPLETE_TASK_URL, new PostCompleteTaskRoute(templateEngine, taskManager));
		post(EDIT_TASK_URL, new PostEditTaskRoute(templateEngine));
		post(REMOVE_TASK_URL, new PostRemoveTaskRoute(templateEngine));
	}
}
