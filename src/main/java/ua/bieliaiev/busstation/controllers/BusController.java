package ua.bieliaiev.busstation.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.bieliaiev.busstation.services.BusService;

@Controller
@AllArgsConstructor
public class BusController {
	private BusService service;

	@GetMapping("/buses")
	public String getRoute(@RequestParam("routeId") int id, Model model) {
		model.addAttribute("buses", service.findAllByRouteId(id));
		return "/buses";
	}
	@GetMapping("/bus")
	public String getBusRoute(@RequestParam("id") int id, Model model) {
		model.addAttribute("busDeparture", service.findById(id));
		return "/bus";
	}
}
