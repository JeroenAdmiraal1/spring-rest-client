package guru.springframework.springrestclient.services;

import guru.springframework.domain.Person;

import java.util.List;

public interface ApiService {

	List<Person> getPersons();
}
