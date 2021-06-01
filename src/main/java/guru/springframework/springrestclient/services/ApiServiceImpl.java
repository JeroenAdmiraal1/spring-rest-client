package guru.springframework.springrestclient.services;

import guru.springframework.domain.Person;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class ApiServiceImpl implements ApiService {

	private RestTemplate restTemplate;

	public ApiServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}


	@Override
	public ArrayList<Person> getPersons() {

		ArrayList<Person> people = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", ArrayList.class);
		return people;
	}
}
