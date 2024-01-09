package com.example.lunajomobile;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar();

        // Sample data for the list view
        List<DesignItem> designList = new ArrayList<>();
        designList.add(new DesignItem("Designer 1", R.drawable.placeholder_image_foreground, "Beautiful design for mobile app"));
        designList.add(new DesignItem("Designer 2", R.drawable.placeholder_image_foreground, "Elegant user interface with modern touch"));
        designList.add(new DesignItem("Designer 3", R.drawable.placeholder_image_foreground, "Simple and intuitive design"));

        // Creating the custom adapter
        DesignListAdapter designListAdapter = new DesignListAdapter(this, designList);

        // Setting the adapter to the ListView
        ListView designListView = findViewById(R.id.designListView);
        designListView.setAdapter(designListAdapter);
    }
}