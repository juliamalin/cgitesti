package net.testi.serverapplication.relationship;

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

import net.testi.serverapplication.person.RequestInfo;


@RestController
@RequestMapping("/api/familyrelationship")
public class FamilyRelationshipController {
    private List<FamilyRelationship> family = new ArrayList<>();
    
    @GetMapping
    public List<FamilyRelationship> getAll() {
        System.out.println("GET request received.");
        return family;
    }
    
    @GetMapping("/{id}")
    public FamilyRelationship getRelationshipById(@PathVariable Integer id) {
        System.out.println("GET id request received.");
        for (FamilyRelationship familyRelationship : family) {
            if (familyRelationship.getId().equals(id)) {
                return familyRelationship;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Relationship not found with id " + id);
    }
    
    @PostMapping
    FamilyRelationship create(@RequestBody FamilyRelationship f) {
    	f.setId((Integer) (family.size() + 1));
    	family.add(f);
        return f;
    }
    
    @PutMapping("/{id}")
    FamilyRelationship updateRelationship(@PathVariable int id, @RequestBody FamilyRelationship updatedRelationship) {
        for (int i = 0; i < family.size(); i++) {
        	FamilyRelationship r = family.get(i);
            if (r.getId().equals(id)) {
                r.setRelationshipType(updatedRelationship.getRelationshipType());
                r.setRelatedPerson(updatedRelationship.getRelatedPerson());
                return r;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Relationship not found with id " + id);
    }
    
    @DeleteMapping("/{id}")
    RequestInfo deleteRelationship(@PathVariable int id) {
        for (int i = 0; i < family.size(); i++) {
        	FamilyRelationship r = family.get(i);
            if (r.getId().equals(id)) {
            	family.remove(i);
        		return new RequestInfo("Deleted");
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Relationship not found with id " + id);
    }


}
