package net.testi.serverapplication.person;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api/people")
public class PersonController {
    private List<Person> people = new ArrayList<>();
    
    @GetMapping
    public List<Person> getAll() {
        System.out.println("GET request received.");
        return people;
    }
    
    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Integer id) {
        System.out.println("GET id request received.");
        for (Person person : people) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found with id " + id);
    }

    @PostMapping
    Person create(@RequestBody Person person) {
        person.setId((Integer) (people.size() + 1));
        people.add(person);
        return person;
    } 
    
    @PutMapping("/{id}")
    Person updatePerson(@PathVariable int id, @RequestBody Person updatedPerson) {
        for (int i = 0; i < people.size(); i++) {
            Person person = people.get(i);
            if (person.getId().equals(id)) {
                person.setFirstName(updatedPerson.getFirstName());
                person.setLastName(updatedPerson.getLastName());
                person.setDateOfBirth(updatedPerson.getDateOfBirth());
                person.setDateOfDeath(updatedPerson.getDateOfDeath());
                person.setAddress(updatedPerson.getAddress());
                person.setCitizenship(updatedPerson.getCitizenship());
                person.setLanguage(updatedPerson.getLanguage());
                person.setFamilyRelationships(updatedPerson.getFamilyRelationships());

                return person;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found with id " + id);
    }

    
    @DeleteMapping("/{id}")
    RequestInfo deletePerson(@PathVariable int id) {
        for (int i = 0; i < people.size(); i++) {
            Person person = people.get(i);
            if (person.getId().equals(id)) {
                people.remove(i);
        		return new RequestInfo("Deleted");
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found with id " + id);
    }
    
    @PostMapping("/checkIfExists")
    public boolean checkIfPersonExists(@RequestBody Person personToCheck) {
        for (Person existingPerson : people) {
            if (existingPerson.equals(personToCheck)) {
                return true;
            }
        }
        
        return false;
    }

    
    
}
