package ua.bieliaiev.busstation.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.bieliaiev.busstation.model.Customer;
import ua.bieliaiev.busstation.services.CustomerService;

@Controller
@AllArgsConstructor
public class CustomerController {
	private final CustomerService service;

	@PostMapping("/buy_ticket")
	public String buyTicket(@RequestParam("busStopId") int id,
						   Customer customer) {
		service.buyTicket(customer, id);
		return "redirect:/";
	}
	@GetMapping("/buy_ticket")
	public String buyTicketPage(@RequestParam("busStopId") int id, Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("busStopId", id);
		return "/buy_ticket";
	}
}
