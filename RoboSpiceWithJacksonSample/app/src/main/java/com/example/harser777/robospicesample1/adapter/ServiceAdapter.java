package com.example.harser777.robospicesample1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.harser777.robospicesample1.R;
import com.example.harser777.robospicesample1.models.ServiceOrder;

import java.util.Arrays;
import java.util.List;

/**
 * Created by harser777 on 12/26/2016.
 */

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceOrderView> {

    Context context;
    List<ServiceOrder> serviceOrderList;

    public ServiceAdapter(Context context, List<ServiceOrder> serviceOrderList) {
        this.context = context;
        this.serviceOrderList = serviceOrderList;
    }

    public class ServiceOrderView extends RecyclerView.ViewHolder{
        public TextView qualified_carriers;
        public TextView qualification_result;
        public TextView zipcode;

        public ServiceOrderView(View view){
            super(view);

            qualified_carriers=(TextView)view.findViewById(R.id.qualified_carriers);
            qualification_result=(TextView)view.findViewById(R.id.qualified_result);
            zipcode=(TextView)view.findViewById(R.id.zipcode);
        }
    }

    @Override
    public ServiceOrderView onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_order_layout, parent, false);
        return new ServiceOrderView(v);
    }

    @Override
    public void onBindViewHolder(ServiceOrderView holder, int position) {
        ServiceOrder serviceOrder = serviceOrderList.get(position);
        final ServiceAdapter.ServiceOrderView serviceOrderView=holder;
        /*
        serviceOrderView.qualified_carriers.setText(Arrays.toString(serviceOrder.getQualifiedCarriers()));
        serviceOrderView.qualification_result.setText(serviceOrder.getQualificationResult());
        serviceOrderView.zipcode.setText(""+serviceOrder.getLocation());*/
        serviceOrderView.qualified_carriers.setText(serviceOrder.getA());
        serviceOrderView.qualification_result.setText(serviceOrder.getB());
        serviceOrderView.zipcode.setText(""+serviceOrder.getC());
    }

    @Override
    public int getItemCount() {
        return serviceOrderList.size();
    }
}
