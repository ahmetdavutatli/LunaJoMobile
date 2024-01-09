package com.example.lunajomobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DesignerProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designer_profile);

        setupToolbar();

        // Sample data for the designer's profile
        String designerName = "John Doe";
        String designerInfo = "Experienced Designer";

        // Displaying designer's information
        TextView designerNameTextView = findViewById(R.id.designerNameTextView);
        designerNameTextView.setText(designerName);

        TextView designerInfoTextView = findViewById(R.id.designerInfoTextView);
        designerInfoTextView.setText(designerInfo);

        // Button to navigate to AddNewDesignActivity
        Button addNewDesignButton = findViewById(R.id.addNewDesignButton);
        addNewDesignButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start AddNewDesignActivity
                startActivity(new Intent(DesignerProfileActivity.this, AddNewDesignActivity.class));
            }
        });
    }
}