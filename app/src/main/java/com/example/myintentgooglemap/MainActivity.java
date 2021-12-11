package com.example.myintentgooglemap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mEdtQuery;
    private EditText mEdtZoom;
    private Button mBtnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtQuery = findViewById(R.id.edt_q);
        mEdtZoom = findViewById(R.id.edtZoom);
        mBtnSearch = findViewById(R.id.button);
        mBtnSearch.setOnClickListener(v -> {
            searchByGoogleMap();
        });
    }

    private void searchByGoogleMap() {
        String value = mEdtQuery.getText().toString().trim();
        String zoom = mEdtZoom.getText().toString().trim();
        if (value.isEmpty()) {
            return;
        }
        if (zoom.isEmpty()) {
            zoom = "16";
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:0, 0?q=" + value + "&z=" + zoom));
        intent.setPackage("com.google.android.apps.maps"); // เจาะจงว่าใช้ Google Maps
        startActivity(intent);
    }
}