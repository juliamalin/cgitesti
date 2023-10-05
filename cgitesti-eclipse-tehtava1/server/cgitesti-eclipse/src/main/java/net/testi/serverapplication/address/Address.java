package net.testi.serverapplication.address;

public class Address {
    private String streetAddress;
    private String postalCode;
    private String city;
    private String country;
    
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }

	    Address otherAddress = (Address) obj;

	    boolean streetAddressEquals = streetAddress.equals(otherAddress.streetAddress);
	    boolean postalCodeEquals = postalCode.equals(otherAddress.postalCode);
	    boolean cityEquals = city.equals(otherAddress.city);
	    boolean countryEquals = country.equals(otherAddress.country);

	    return streetAddressEquals && postalCodeEquals && cityEquals && countryEquals;
	}
	
	public Address copy() {
	    Address copy = new Address();
	    copy.setStreetAddress(this.streetAddress);
	    copy.setPostalCode(this.postalCode);
	    copy.setCity(this.city);
	    copy.setCountry(this.country);
	    return copy;
	}



}


