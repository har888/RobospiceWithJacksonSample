package com.example.harser777.robospicesample1.models;

/**
 * Created by harser777 on 12/25/2016.
 */

public class PostalAddress {

    private String zipcode;

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return getZipcode();
    }
}
