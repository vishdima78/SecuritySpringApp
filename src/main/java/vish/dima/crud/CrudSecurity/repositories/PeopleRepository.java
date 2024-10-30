package vish.dima.crud.CrudSecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vish.dima.crud.CrudSecurity.models.Person;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<Person,Integer> {

    Optional<Person> findByName(String username);
}
