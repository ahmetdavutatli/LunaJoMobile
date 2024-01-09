package com.example.lunajomobile;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddNewDesignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_design);

        // EditTexts for design information
        EditText designNameEditText = findViewById(R.id.designNameEditText);
        EditText designDescriptionEditText = findViewById(R.id.designDescriptionEditText);

        // Button to save the new design (You should implement the save logic)
        Button saveDesignButton = findViewById(R.id.saveDesignButton);
        saveDesignButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve design information from EditTexts
                String designName = designNameEditText.getText().toString();
                String designDescription = designDescriptionEditText.getText().toString();

                // You should implement the logic to save the new design
                // For simplicity, we'll just finish the activity in this example
                finish();
            }
        });
    }
}