package guru.springframework.springrestclient.services;

import guru.springframework.domain.Person;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ApiService {

	List<Person> getPersons();

	Flux<Person> getFluxOfPersons();
}
