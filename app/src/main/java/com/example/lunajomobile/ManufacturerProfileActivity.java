package com.example.lunajomobile;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ManufacturerProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manufacturer_profile);

        setupToolbar();

        // Sample data for the manufacturer's profile
        String manufacturerName = "XYZ Manufacturing";
        String manufacturerInfo = "Quality Manufacturer";

        // Displaying manufacturer's information
        TextView manufacturerNameTextView = findViewById(R.id.manufacturerNameTextView);
        manufacturerNameTextView.setText(manufacturerName);

        TextView manufacturerInfoTextView = findViewById(R.id.manufacturerInfoTextView);
        manufacturerInfoTextView.setText(manufacturerInfo);
    }
}