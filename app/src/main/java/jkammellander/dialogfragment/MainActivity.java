package jkammellander.dialogfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the standard_button and set a click listener on it
        findViewById(R.id.standard_button).setOnClickListener(view -> {
            // show the standard dialog fragment (using the FragmentManager) in the fragment_container
            StandardFragment fragment = new StandardFragment();
            fragment.show(getSupportFragmentManager(), StandardFragment.TAG);
        });

        // get the custom_button and set a click listener on it
        findViewById(R.id.custom_button).setOnClickListener(view -> {
            // show the custom dialog fragment (using the FragmentManager) in the fragment_container
            CustomFragment fragment = new CustomFragment();
            fragment.show(getSupportFragmentManager(), CustomFragment.TAG);
        });

    }
}