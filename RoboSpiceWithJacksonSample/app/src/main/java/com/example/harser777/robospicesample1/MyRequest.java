package com.example.harser777.robospicesample1;

import com.example.harser777.robospicesample1.models.ServiceOrders;
import com.octo.android.robospice.request.springandroid.SpringAndroidSpiceRequest;

/**
 * Created by harser777 on 12/26/2016.
 */

public class MyRequest extends SpringAndroidSpiceRequest<ServiceOrders> {

    private String user;

    public MyRequest(String user) {
        super(ServiceOrders.class);
        this.user = user;
    }

    @Override
    public ServiceOrders loadDataFromNetwork() throws Exception {
        String url = "http://www.sernaharold.com/test1/orderserviceinfo.php?";

     /*   RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        URI uri = new URI(url);
        ServiceOrders serviceOrders = restTemplate.getForObject(uri, ServiceOrders.class);
        Log.i("serviceOrderSuccess:", serviceOrders.toString());
        return serviceOrders;*/
       return getRestTemplate().getForObject(url, ServiceOrders.class);

    }

    public String createCacheKey(){
        return "serviceorder"+user;
    }
}
