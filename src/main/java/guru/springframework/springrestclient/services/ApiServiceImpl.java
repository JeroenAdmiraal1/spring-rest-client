package guru.springframework.springrestclient.services;

import guru.springframework.domain.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

	private final String api_url;

	private final RestTemplate restTemplate;

	public ApiServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String api_url) {
		this.restTemplate = restTemplate;
		this.api_url = api_url;
	}

	@Override
	public List<Person> getPersons() {

		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(api_url);

		Person[] persons = restTemplate.getForObject(uriComponentsBuilder.toUriString(), Person[].class);

		return Arrays.asList(persons);
	}
}
