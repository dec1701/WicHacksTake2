package View;

import spark.*;

import java.util.HashMap;
import java.util.Map;

public class PostRemoveTaskRoute implements Route {
	private final TemplateEngine templateEngine;

	public PostRemoveTaskRoute(TemplateEngine templateEngine){ this.templateEngine = templateEngine; }

	public Object handle(Request request, Response response){
		final Session httpSession = request.session();

		Map<String, Object> vm = new HashMap<String, Object>();
		vm.put("title", "Remove");

		return templateEngine.render(new ModelAndView(vm, "remove.ftl"));
	}
}
