package com.example.harser777.robospicesample1.models;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harser777 on 12/26/2016.
 */
//@JsonIgnoreProperties(ignoreUnknown=true)

public class ServiceOrders{//} extends ArrayList<ServiceOrder> {

    public ServiceOrders(){

    }


    private ArrayList<ServiceOrder>ServiceOrder;

    @JsonProperty("ServiceOrder")
    public ArrayList<com.example.harser777.robospicesample1.models.ServiceOrder> getServiceOrder() {
        return ServiceOrder;
    }

    public void setServiceOrder(ArrayList<com.example.harser777.robospicesample1.models.ServiceOrder> serviceOrder) {
        ServiceOrder = serviceOrder;
    }
}
