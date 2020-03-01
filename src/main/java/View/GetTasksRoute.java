package View;

import spark.*;

import java.util.HashMap;
import java.util.Map;

public class GetTasksRoute implements Route {
	private final TemplateEngine templateEngine;

	public GetTasksRoute(TemplateEngine templateEngine){ this.templateEngine = templateEngine; }

	public Object handle(Request request, Response response){
		final Session httpSession = request.session();

		Map<String, Object> vm = new HashMap<String, Object>();
		vm.put("title", "Tasks");

		return templateEngine.render(new ModelAndView(vm, "Tasks"));
	}
}
