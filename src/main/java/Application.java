import Controller.TaskManager;
import com.google.gson.Gson;
import spark.Spark;

import View.WebServer;
import spark.TemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;


public class Application {

	public static void main(String[] args) {
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
