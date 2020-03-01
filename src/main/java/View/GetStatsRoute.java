package View;

import spark.*;

import java.util.Map;


import java.util.HashMap;

public class GetStatsRoute implements Route {

	private final TemplateEngine templateEngine;

	public GetStatsRoute(TemplateEngine templateEngine){ this.templateEngine = templateEngine; }

	public Object handle(Request request, Response response){
		final Session httpSession = request.session();

		Map<String, Object> vm = new HashMap<String, Object>();
		vm.put("title", "Stats");

		return templateEngine.render(new ModelAndView(vm, "stats.ftl"));
	}
}
