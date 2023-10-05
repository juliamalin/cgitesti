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
    
    @PostMapping
    FamilyRelationship create(@RequestBody FamilyRelationship f) {
    	family.add(f);
        return f;
    }
}
