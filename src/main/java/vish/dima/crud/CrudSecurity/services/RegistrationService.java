package vish.dima.crud.CrudSecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vish.dima.crud.CrudSecurity.models.Person;
import vish.dima.crud.CrudSecurity.repositories.PeopleRepository;

@Service
public class RegistrationService {

    private final PasswordEncoder passwordEncoder;
    private final PeopleRepository peopleRepository;

    @Autowired
    public RegistrationService(PasswordEncoder passwordEncoder, PeopleRepository peopleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.peopleRepository = peopleRepository;
    }

    @Transactional
    public void register(Person person) {

        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole("ROLE_USER");
        peopleRepository.save(person);
    }
}
