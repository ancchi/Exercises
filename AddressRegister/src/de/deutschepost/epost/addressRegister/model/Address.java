
package de.deutschepost.epost.addressRegister.model;

public class Address {
    private long addressID;
    private String prename;
    private String lastName;
    private String street;
    private String streetNumber;
    private String postcode;
    private String location;

    public Address() {}

    public Address(long addressID, String prename, String lastName, String street, String streetNumber, String postcode, String location) {
        this.prename = prename;
        this.lastName = lastName;
        this.street = street;
        this.streetNumber = streetNumber;
        this.postcode = postcode;
        this.location = location;
        this.addressID = addressID;
    }

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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (!getPrename().equals(address.getPrename())) return false;
        if (!getLastName().equals(address.getLastName())) return false;
        if (getStreet() != null ? !getStreet().equals(address.getStreet()) : address.getStreet() != null) return false;
        if (getStreetNumber() != null ? !getStreetNumber().equals(address.getStreetNumber()) : address.getStreetNumber() != null)
            return false;
        if (postcode != null ? !postcode.equals(address.postcode) : address.postcode != null) return false;
        return getLocation() != null ? getLocation().equals(address.getLocation()) : address.getLocation() == null;

    }

    @Override
    public int hashCode() {
        int result = getPrename().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + (getStreet() != null ? getStreet().hashCode() : 0);
        result = 31 * result + (getStreetNumber() != null ? getStreetNumber().hashCode() : 0);
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        result = 31 * result + (getLocation() != null ? getLocation().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "prename='" + prename + '\'' +
                ", lastName='" + lastName + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", postcode='" + postcode + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
