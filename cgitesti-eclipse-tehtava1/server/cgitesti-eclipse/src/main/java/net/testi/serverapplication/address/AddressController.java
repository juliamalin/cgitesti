package net.testi.serverapplication.address;

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
@RequestMapping("/api/address")
public class AddressController {
    private List<Address> address = new ArrayList<>();
    
    @GetMapping
    public List<Address> getAll() {
        System.out.println("GET request received.");
        return address;
    }
    
    
    @PostMapping
    Address create(@RequestBody Address a) {
    	address.add(a);
        return a;
    }
}

