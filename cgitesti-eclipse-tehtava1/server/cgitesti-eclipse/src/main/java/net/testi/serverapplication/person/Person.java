package net.testi.serverapplication.person;

import java.time.LocalDate;
import java.util.List;

import net.testi.serverapplication.address.Address;
import net.testi.serverapplication.relationship.FamilyRelationship;


public class Person {
    private Integer id;
    private String firstName;
    private String lastName;
    private Address address;
    private String citizenship;
    private String language;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private List<FamilyRelationship> familyRelationships;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCitizenship() {
		return citizenship;
	}
	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public LocalDate getDateOfDeath() {
		return dateOfDeath;
	}
	public void setDateOfDeath(LocalDate dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}
	public List<FamilyRelationship> getFamilyRelationships() {
		return familyRelationships;
	}
	public void setFamilyRelationships(List<FamilyRelationship> familyRelationships) {
		this.familyRelationships = familyRelationships;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	

}
