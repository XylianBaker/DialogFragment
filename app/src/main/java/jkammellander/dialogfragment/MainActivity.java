package jkammellander.dialogfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyCustomDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting a click listener on the standard_button. When the button is clicked, it gets the
        // text from the text_input EditText and puts it in a Bundle. Then it creates a new
        // StandardFragment and sets the Bundle as the arguments. Finally, it shows the fragment.
        findViewById(R.id.standard_button).setOnClickListener(view -> {
            String textInput = ((EditText) findViewById(R.id.text_input)).getText().toString();
            StandardFragment fragment = new StandardFragment();
            Bundle args = new Bundle();
            args.putString("text", textInput);
            fragment.setArguments(args);
            fragment.show(getSupportFragmentManager(), StandardFragment.TAG);
        });

        // Setting a click listener on the custom_button. When the button is clicked, it gets the
        // text from the text_input EditText and puts it in a Bundle. Then it creates a new
        // CustomFragment and sets the Bundle as the arguments. Finally, it shows the fragment.
        findViewById(R.id.custom_button).setOnClickListener(view -> {
            String textInput = ((EditText) findViewById(R.id.text_input)).getText().toString();
            CustomFragment fragment = new CustomFragment();
            Bundle args = new Bundle();
            args.putString("text", textInput);
            fragment.setArguments(args);
            fragment.show(getSupportFragmentManager(), CustomFragment.TAG);
        });

    }

    /**
     * When the dialog is finished, set the text of the TextView to the inputText.
     *
     * @param inputText The text that the user entered in the dialog.
     */
    @Override
    public void onFinishedDialog(String inputText) {
        ((TextView) findViewById(R.id.textView)).setText(inputText);
    }
}