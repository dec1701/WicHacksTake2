package View;

import spark.*;

import java.util.HashMap;
import java.util.Map;

public class PostEditTaskRoute implements Route {

	private final TemplateEngine templateEngine;

	public PostEditTaskRoute(TemplateEngine templateEngine){ this.templateEngine = templateEngine; }

	public Object handle(Request request, Response response){
		final Session httpSession = request.session();

		Map<String, Object> vm = new HashMap<String, Object>();
		vm.put("title", "Edit");

		return templateEngine.render(new ModelAndView(vm, "edit.ftl"));
	}
}
