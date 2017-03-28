package com.example.harser777.robospicesample1.models;

/**
 * Created by harser777 on 12/25/2016.
 */

public class Location {

    private PostalAddress postalAddress;

    public PostalAddress getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
    }

    @Override
    public String toString() {
        return getPostalAddress().toString();
    }
}
