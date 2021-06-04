package guru.springframework.springrestclient.controllers;

import guru.springframework.springrestclient.services.ApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	private ApiService apiService;

	public IndexController(ApiService apiService) {
		this.apiService = apiService;
	}

	@GetMapping({"", "/", "/index", "/index/"})
	public String getIndex(){
		return "index";
	}

	@GetMapping("/people")
	public String getPeople(Model model){

		model.addAttribute("persons", apiService.getPersons());

		return "people";
	}

	@GetMapping("/peopleflux")
	public String getPeopleFlux(Model model){

		model.addAttribute("persons", apiService.getFluxOfPersons().collectList().block());

		return "people";
	}
}
