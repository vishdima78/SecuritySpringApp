package vish.dima.crud.CrudSecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vish.dima.crud.CrudSecurity.models.Person;
import vish.dima.crud.CrudSecurity.repositories.PeopleRepository;
import vish.dima.crud.CrudSecurity.security.PersonDetails;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Optional<Person> person =  peopleRepository.findByName(username);
        if (person.isEmpty())
            throw new UsernameNotFoundException("user not found");
        return new PersonDetails(person.get());
    }
}
