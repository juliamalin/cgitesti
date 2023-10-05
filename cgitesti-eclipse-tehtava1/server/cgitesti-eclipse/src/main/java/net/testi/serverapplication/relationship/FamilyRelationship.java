package net.testi.serverapplication.relationship;


public class FamilyRelationship {
    private String relationshipType;
    private String relatedPersonSSN;
    
	public String getRelatedPersonSSN() {
		return relatedPersonSSN;
	}
	public void setRelatedPersonSSN(String relatedPersonSSN) {
		this.relatedPersonSSN = relatedPersonSSN;
	}
	public String getRelationshipType() {
		return relationshipType;
	}
	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }

	    FamilyRelationship otherRelationship = (FamilyRelationship) obj;

	    boolean relationshipTypeEquals = relationshipType.equals(otherRelationship.relationshipType);
	    boolean relatedPersonSSNEquals = relatedPersonSSN.equals(otherRelationship.relatedPersonSSN);

	    return relationshipTypeEquals && relatedPersonSSNEquals;
	}
	
	public FamilyRelationship copy() {
	    FamilyRelationship copy = new FamilyRelationship();
	    copy.setRelationshipType(this.relationshipType);
	    copy.setRelatedPersonSSN(this.relatedPersonSSN);
	    return copy;
	}

}

