package com.example.harser777.robospicesample1;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.harser777.robospicesample1.adapter.ServiceAdapter;
import com.example.harser777.robospicesample1.models.ServiceOrder;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.harser777.robospicesample1.models.ServiceOrders;
import com.octo.android.robospice.JacksonSpringAndroidSpiceService;
import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ServiceAdapter serviceAdapter;
    ArrayList<ServiceOrder> serviceOrderArrayList;
    Context context;

    //robospice
    private SpiceManager spiceManager = new SpiceManager(
            JacksonSpringAndroidSpiceService.class);

    private String lastRequestCacheKey;
    ////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context=this;
        serviceOrderArrayList=new ArrayList<>();
        recyclerView=(RecyclerView)findViewById(R.id.rv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        serviceAdapter = new ServiceAdapter(this, serviceOrderArrayList);
        recyclerView.setAdapter(serviceAdapter);


        //JACKSON READ FROM FILE IN RAW FOLDER
       /* ObjectMapper mapper = new ObjectMapper();
        InputStream is = this.getResources().openRawResource(R.raw.serviceorder1);
        Log.i("ServiceOrder:", "onCreate");
        try {
            ServiceOrder serviceOrder = mapper.readValue(is, ServiceOrder.class);
            Log.i("serviceOrder: \n", serviceOrder.toString());
        } catch (IOException e) {
            Log.i("serviceOrder: Failed", "FAILED");
            e.printStackTrace();

        }*/

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Log.i("MainActivity", "onClick");
                performRequest("ok");
            }
        });
    }

    private class ListRequestListener implements RequestListener<ServiceOrders> {

        @Override
        public void onRequestFailure(SpiceException e) {
            Log.i("MainActivity", "onRequestFailure");
            //update your UI
            Toast.makeText(MainActivity.this,
                    "Error during request: " + e.getLocalizedMessage(), Toast.LENGTH_LONG)
                    .show();
            MainActivity.this.setProgressBarIndeterminateVisibility(false);
        }

        @Override
        public void onRequestSuccess(ServiceOrders serviceOrders) {
            //update your UI
            Log.i("MainActivity", "onRequestSuccess");

            if(serviceOrders==null){
                Log.i("MainActivity", "onRequestSuccessNULL");
                return;
            }
            serviceOrderArrayList.clear();

            for(ServiceOrder serviceOrder : serviceOrders.getServiceOrder()){
                serviceOrderArrayList.add(serviceOrder);
            }

            serviceAdapter.notifyDataSetChanged();
            MainActivity.this.setProgressBarIndeterminateVisibility(false);
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        spiceManager.start(this);
    }

    @Override
    protected void onStop() {
        spiceManager.shouldStop();
        super.onStop();
    }

    private void performRequest(String user){
        MainActivity.this.setProgressBarIndeterminateVisibility(true);
        MyRequest request = new MyRequest(user);
        lastRequestCacheKey=request.createCacheKey();

        spiceManager.execute(request, lastRequestCacheKey, DurationInMillis.ONE_MINUTE, new ListRequestListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
