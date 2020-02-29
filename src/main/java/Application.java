import spark.Spark;

import View.WebServer;

public class Application {

	private final WebServer webServer;

	private Application(final WebServer webServer){
		this.webServer = webServer;
	}

	private void initialize(){
		//webServer.initialize();
	}

	public static void main(String[] args) {
		//final TemplateEngine templateEngine = new FreeMarkerEngine();
	}
}
