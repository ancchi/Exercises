
package de.epost.addressRegister.model;

public class Address {
    private String prename;
    private String lastName;
    private String street;
    private String streetNumber;
    private String postcode;
    private String location;

    
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }
    
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostCode() {
        return postcode;
    }

    public void setPostCode(String postcode) {
        this.postcode = postcode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    // verkürzt für Test
    public String toString() { // die Standard-Methode toString() dieser Klasse muss überschrieben werden
        return prename + " " + lastName;
    }

//    // vollständig
//    public String toString() {
//        return prename + " " + lastName + "\n" + street + " " +
//                streetNumber + "\n" + postcode + " " + location;
//    }
    
}
