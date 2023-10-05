package net.testi.serverapplication.relationship;

import net.testi.serverapplication.person.Person;

public class FamilyRelationship {
    private Integer id;
    private String relationshipType;
    private Person relatedPerson;
    
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
    
	public String getRelationshipType() {
		return relationshipType;
	}
	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}
	public Person getRelatedPerson() {
		return relatedPerson;
	}
	public void setRelatedPerson(Person relatedPerson) {
		this.relatedPerson = relatedPerson;
	}

}

