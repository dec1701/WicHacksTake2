package View;

import spark.*;

import java.util.HashMap;
import java.util.Map;

public class PostCompleteTaskRoute implements Route {
	private final TemplateEngine templateEngine;

	public PostCompleteTaskRoute(TemplateEngine templateEngine){ this.templateEngine = templateEngine; }

	public Object handle(Request request, Response response){
		final Session httpSession = request.session();

		Map<String, Object> vm = new HashMap<String, Object>();
		vm.put("title", "Complete");

		return templateEngine.render(new ModelAndView(vm, "complete.ftl"));
	}
}
