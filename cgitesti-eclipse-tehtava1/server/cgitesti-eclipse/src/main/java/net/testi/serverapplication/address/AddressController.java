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
    
    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable Integer id) {
        System.out.println("GET id request received.");
        for (Address address : address) {
            if (address.getId().equals(id)) {
                return address;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found with id " + id);
    }
    
    @PostMapping
    Address create(@RequestBody Address a) {
    	a.setId((Integer) (address.size() + 1));
    	address.add(a);
        return a;
    }
    
    @PutMapping("/{id}")
    Address updateAddress(@PathVariable int id, @RequestBody Address updatedAddress) {
        for (int i = 0; i < address.size(); i++) {
        	Address a = address.get(i);
            if (a.getId().equals(id)) {
                a.setStreetAddress(updatedAddress.getStreetAddress());
                a.setPostalCode(updatedAddress.getPostalCode());
                a.setCity(updatedAddress.getCity());
                a.setStreetAddress(updatedAddress.getStreetAddress());
                a.setCountry(updatedAddress.getCountry());
                return a;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found with id " + id);
    }
    
    @DeleteMapping("/{id}")
    RequestInfo deleteAddress(@PathVariable int id) {
        for (int i = 0; i < address.size(); i++) {
            Address a = address.get(i);
            if (a.getId().equals(id)) {
            	address.remove(i);
        		return new RequestInfo("Deleted");
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found with id " + id);
    }
}

