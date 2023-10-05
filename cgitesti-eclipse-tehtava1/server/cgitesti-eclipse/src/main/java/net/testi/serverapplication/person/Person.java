package net.testi.serverapplication.person;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
	
	@Override
	public String toString() {
	    return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName +
	    		", address=" + address + ", citizenship=" + citizenship +", language=" + language +
	    		", dateOfBirth" + dateOfBirth + ", dateOfDeath" + dateOfDeath + ", familyRelationships" +
	    		familyRelationships + "]";
	}

	
	@Override
	public boolean equals(Object obj) {
	     if (this == obj) {
	         return true;
	     }
	     if (obj == null || getClass() != obj.getClass()) {
	         return false;
	     }

	     Person otherPerson = (Person) obj;

	     boolean firstNameEquals = firstName.equals(otherPerson.firstName);
	     boolean lastNameEquals = lastName.equals(otherPerson.lastName);
	     boolean dateOfBirthEquals = dateOfBirth.equals(dateOfBirth);
	     boolean citizenshipEquals = citizenship.equals(otherPerson.citizenship);
	     boolean languageEquals = language.equals(otherPerson.language);
	     boolean dateOfDeathEquals = dateOfDeath.equals(dateOfDeath);
	     boolean addressEquals = Objects.equals(address, otherPerson.address);
	     boolean familyRelationshipsEquals = Objects.equals(familyRelationships, otherPerson.familyRelationships);

	     if (!firstNameEquals) {
	         System.out.println("firstName ero: " + firstName + " vs. " + otherPerson.firstName);
	     }
	     if (!lastNameEquals) {
	         System.out.println("lastName ero: " + lastName + " vs. " + otherPerson.lastName);
	     }
	     if (!dateOfBirthEquals) {
	         System.out.println("dateOfBirth ero: " + dateOfBirth + " vs. " + otherPerson.dateOfBirth);
	     }
	     if (!citizenshipEquals) {
	         System.out.println("citizenship ero: " + citizenship + " vs. " + otherPerson.citizenship);
	     }
	     if (!languageEquals) {
	         System.out.println("language ero: " + language + " vs. " + otherPerson.language);
	     }
	     if (!dateOfDeathEquals) {
	         System.out.println("dateOfDeath ero: " + dateOfDeath + " vs. " + otherPerson.dateOfDeath);
	     }
	     if (!addressEquals) {
	         System.out.println("address ero: " + address + " vs. " + otherPerson.address);
	     }
	     if (!familyRelationshipsEquals) {
	         System.out.println("familyRelationships ero: " + familyRelationships + " vs. " + otherPerson.familyRelationships);
	     }

	     return firstNameEquals && lastNameEquals && dateOfBirthEquals && citizenshipEquals &&
	            languageEquals && dateOfDeathEquals && addressEquals && familyRelationshipsEquals;
	 }
	 
	 public Person copy() {
		    Person copy = new Person();
		    copy.setId(this.id);
		    copy.setFirstName(this.firstName);
		    copy.setLastName(this.lastName);
		    copy.setAddress(this.address.copy());
		    copy.setCitizenship(this.citizenship);
		    copy.setLanguage(this.language);
		    copy.setDateOfBirth(this.dateOfBirth);
		    copy.setDateOfDeath(this.dateOfDeath);

		    List<FamilyRelationship> copiedRelationships = new ArrayList<>();
		    for (FamilyRelationship relationship : this.familyRelationships) {
		        copiedRelationships.add(relationship.copy()); 
		    }
		    copy.setFamilyRelationships(copiedRelationships);

		    return copy;
		}
	 
	public int calculateAge() {
		 LocalDate today = LocalDate.now();
		 Period age = Period.between(dateOfBirth, today);
		 return age.getYears();
	}
	 
}
