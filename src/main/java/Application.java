import Controller.StatsManager;
import Controller.TaskManager;
import View.GetTasksRoute;
import com.google.gson.Gson;
import freemarker.template.Configuration;
import org.eclipse.jetty.websocket.common.io.AbstractWebSocketConnection;
import spark.Spark;

import View.WebServer;
import spark.TemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;

import java.io.File;
import java.io.IOException;


public class Application {

	public static void main(String[] args) {

		Configuration config = new Configuration();
		try {
			config.setDirectoryForTemplateLoading(new File("src/main/resources/spark.template.freemarker"));
		}catch (IOException e){}


        //freemarker.template.Configuration.

		final TemplateEngine templateEngine = new FreeMarkerEngine(config);
		final Gson gson = new Gson();

		//Controller classes
		final TaskManager taskManager = new TaskManager();
		final StatsManager statsManager = new StatsManager();

		final WebServer webServer = new WebServer(templateEngine, gson, taskManager, statsManager);

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
