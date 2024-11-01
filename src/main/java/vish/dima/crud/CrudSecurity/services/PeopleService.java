package vish.dima.crud.CrudSecurity.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vish.dima.crud.CrudSecurity.models.Person;
import vish.dima.crud.CrudSecurity.repositories.PeopleRepository;

import java.util.Optional;

@Service
public class PeopleService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public Optional<Person> findByName(String name) {
        return peopleRepository.findByName(name).stream().findAny();
    }
}
