package com.baz.examenandroidbaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnMyComrades, btnAddComrade;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        btnAddComrade = findViewById(R.id.activity_main_add_comrade);
        btnMyComrades = findViewById(R.id.activity_main_comrades_button);
    }


    public void showFragment(View view) {
        switch (view.getId()) {
            case R.id.activity_main_add_comrade:
                intent = new Intent(getApplicationContext(), AddComrades.class);
                startActivity(intent);
                break;

            case R.id.activity_main_comrades_button:
                intent = new Intent(getApplicationContext(), MyComrades.class);
                startActivity(intent);
                break;

        }

    }
}