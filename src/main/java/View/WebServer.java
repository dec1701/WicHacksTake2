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
	public static final String TASKS_URL = "/Tasks";
	public static final String ADD_TASK_URL = "/Add";
	public static final String COMPLETE_TASK_URL = "/Complete";
	public static final String EDIT_TASK_URL = "/Edit";
	public static final String REMOVE_TASK_URL = "/Remove";


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
		get(TASKS_URL, new GetTasksRoute(templateEngine, taskManager));
		get(EDIT_TASK_URL, new GetEditTaskRoute(templateEngine, taskManager));
		post(ADD_TASK_URL, new PostAddTaskRoute(templateEngine, taskManager));
		post(COMPLETE_TASK_URL, new PostCompleteTaskRoute(templateEngine, taskManager));
		post(REMOVE_TASK_URL, new PostRemoveTaskRoute(templateEngine));
		post(TASKS_URL, new PostTasksRoute(templateEngine, taskManager));
		post(EDIT_TASK_URL, new PostEditTaskRoute(templateEngine, taskManager));
	}
}
