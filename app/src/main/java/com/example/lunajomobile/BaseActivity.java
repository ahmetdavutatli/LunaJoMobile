package com.example.lunajomobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class BaseActivity extends AppCompatActivity {

    private String userType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void setupToolbar() {
        // Get user type from your authentication mechanism (e.g., SharedPreferences)
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        userType = preferences.getString("userType", ""); // Replace with your actual key

        // Set up the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_profile) {
            navigateToProfile();
            return true;
        } else if (itemId == R.id.action_logout) {
            logout();
            return true;
        } else if (itemId == R.id.action_home) {
            navigateToMainActivity();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void navigateToProfile() {
        // Navigate to the appropriate profile based on user type
        Class<?> profileClass = "designer".equals(userType) ? DesignerProfileActivity.class : ManufacturerProfileActivity.class;
        Intent profileIntent = new Intent(this, profileClass);
        startActivity(profileIntent);
    }

    protected void logout() {
        // Clear user data (example using SharedPreferences)
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();

        // Navigate to LoginActivity
        Intent loginIntent = new Intent(this, LoginActivity.class);
        startActivity(loginIntent);
        finish();  // Finish the current activity to prevent going back to it using the back button
    }

    protected void navigateToMainActivity() {
        // Navigate to MainActivity
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
        finish();  // Finish the current activity to prevent going back to it using the back button
    }
}