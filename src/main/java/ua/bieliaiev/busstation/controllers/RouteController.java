package ua.bieliaiev.busstation.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.bieliaiev.busstation.services.RouteService;

@Controller
@AllArgsConstructor
public class RouteController {

	private RouteService service;

	@GetMapping("/route")
	public String getRoute(@RequestParam("id") int id, Model model) {
		model.addAttribute("route", service.findRouteById(id));
		return "/route";
	}

}
