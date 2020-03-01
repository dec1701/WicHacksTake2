import Controller.TaskManager;
import View.GetTasksRoute;
import com.google.gson.Gson;
import freemarker.template.Configuration;
import spark.Spark;

import View.WebServer;
import spark.TemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;


public class Application {

	public static void main(String[] args) {

		//Configuration config = new Configuration();
		//config.setClassForTemplateLoading(GetTasksRoute.class, "/src/resources/spark.template.freemarker");

		final TemplateEngine templateEngine = new FreeMarkerEngine();
		final Gson gson = new Gson();

		//Controller classes
		final TaskManager taskManager = new TaskManager();

		final WebServer webServer = new WebServer(templateEngine, gson, taskManager);

		final Application app = new Application(webServer);
		app.initialize();
	}

	private final WebServer webServer;

	private Application(final WebServer webServer){
		this.webServer = webServer;
	}

	private void initialize(){
		webServer.initialize();
	}
}
