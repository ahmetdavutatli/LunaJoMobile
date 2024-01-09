package com.example.lunajomobile;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DesignDetailsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_details);

        setupToolbar();

        // Retrieve the selected design name from the intent
        String selectedDesign = getIntent().getStringExtra("selectedDesign");

        // Display the selected design name
        TextView designDetailsTextView = findViewById(R.id.designDetailsTextView);
        designDetailsTextView.setText("Details for: " + selectedDesign);

        // For simplicity, let's use a placeholder image
        ImageView designImageView = findViewById(R.id.designImageView);
        designImageView.setImageResource(R.drawable.placeholder_image_foreground);
    }
}