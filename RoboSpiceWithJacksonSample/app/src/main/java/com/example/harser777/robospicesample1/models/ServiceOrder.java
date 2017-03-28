package com.example.harser777.robospicesample1.models;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Arrays;

/**
 * Created by harser777 on 12/25/2016.
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class ServiceOrder {

    @JsonProperty("qualified_carriers")
    String a;
    //@JsonProperty("b")
    @JsonProperty("qualification_result")
    String b;
    //@JsonProperty("c")
    @JsonProperty("zipcode")
    String c;

    public ServiceOrder(){

    }

    public ServiceOrder(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("** Service Order Details **\n");
        sb.append("qualified carriers="+ getA()+"\n");
        sb.append("qualification result="+getB()+"\n");
        sb.append("location="+getC());

        return sb.toString();
    }

    /* private String [] qualifiedCarriers;
    private String qualificationResult;
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getQualificationResult() {
        return qualificationResult;
    }

    public void setQualificationResult(String qualificationResult) {
        this.qualificationResult = qualificationResult;
    }

    public String[] getQualifiedCarriers() {
        return qualifiedCarriers;
    }

    public void setQualifiedCarriers(String[] qualifiedCarriers) {
        this.qualifiedCarriers = qualifiedCarriers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("** Service Order Details **\n");
        sb.append("qualified carriers="+ Arrays.toString(getQualifiedCarriers())+"\n");
        sb.append("qualification result="+getQualificationResult()+"\n");
        sb.append("location="+getLocation());

        return sb.toString();
    }*/
}
