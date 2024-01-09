package com.example.lunajomobile;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MakeOfferActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_offer);

        setupToolbar();

        // Sample data for the offer page
        String selectedDesign = getIntent().getStringExtra("selectedDesign");
        String manufacturerName = "XYZ Manufacturing";
        String designDetails = "Details for: " + selectedDesign;

        // Displaying offer information
        TextView manufacturerTextView = findViewById(R.id.manufacturerTextView);
        manufacturerTextView.setText("Manufacturer: " + manufacturerName);

        TextView designDetailsTextView = findViewById(R.id.designDetailsTextView);
        designDetailsTextView.setText(designDetails);

        // Button to submit the offer (You should implement the offer submission logic)
        Button submitOfferButton = findViewById(R.id.submitOfferButton);
        submitOfferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // You should implement the logic to submit the offer
                // For simplicity, we'll just finish the activity in this example
                finish();
            }
        });
    }
}