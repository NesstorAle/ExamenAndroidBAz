package com.baz.examenandroidbaz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;

import com.baz.examenandroidbaz.adapter.Adapter;
import com.baz.examenandroidbaz.data.EmployeEntity;
import com.baz.examenandroidbaz.data.Location;
import com.baz.examenandroidbaz.fragment.LocationsFragment;

import java.util.ArrayList;

public class MyComrades extends AppCompatActivity{
    ArrayList<EmployeEntity> listDatos;
    RecyclerView recyclerView;
    Fragment frLocations;
    EmployeEntity emp;
    Location loc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_comrades);

        recyclerView = findViewById(R.id.activity_my_comrades_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
        frLocations = new LocationsFragment();
        listDatos = new ArrayList<>();

        getEmployees();

        Adapter adapter = new Adapter(listDatos);
        adapter.setOnclicklistener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateLocation();
            }
        });
        recyclerView.setAdapter(adapter);

        getSupportFragmentManager().beginTransaction().replace(R.id.activity_comrades_container, frLocations).commit();
    }

    private void getEmployees() {
            emp = new EmployeEntity();
            emp.setName("Daniel Alejandro Catañeda" );
            emp.setMail("alejandro@upaxer.com" );
            loc = new Location();
            loc.setLat(19.300378);
            loc.setLog(-99.2009822);
            emp.setLocation(loc);
            listDatos.add(emp);
    }

    private void updateLocation() {

    }

}