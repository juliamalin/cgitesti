package net.testi.serverapplication.person.tests;

import org.junit.Before;
import org.junit.Test;

import net.testi.serverapplication.address.Address;
import net.testi.serverapplication.person.Person;
import net.testi.serverapplication.relationship.FamilyRelationship;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonTests {

    private Person person;
    
    @Before
    public void setUp() {
        person = new Person();
        person.setId(1);
        person.setFirstName("Pekka");
        person.setLastName("Pouta");
        person.setCitizenship("FIN");
        person.setLanguage("Suomi");
        person.setDateOfBirth(LocalDate.of(1990, 1, 1));
        person.setDateOfDeath(LocalDate.of(2023, 8, 21));
        
        Address address = new Address();
        address.setStreetAddress("Fredrikinkatu");
        address.setPostalCode("12345");
        address.setCity("Helsinki");
        address.setCountry("Suomi");
        person.setAddress(address);
        
        List<FamilyRelationship> relationships = new ArrayList<>();
        FamilyRelationship spouse = new FamilyRelationship();
        spouse.setRelationshipType("Puoliso");
        spouse.setRelatedPersonSSN("123456789");
        relationships.add(spouse);
        person.setFamilyRelationships(relationships);
    }
    
    @Test
    public void testEquals() {
        Person copy = person.copy();
        assertTrue(person.equals(copy));
    }
    
    @Test
    public void testAgeCalculation() {
        int age = person.calculateAge();
        assertEquals(33, age);
    } 
}

