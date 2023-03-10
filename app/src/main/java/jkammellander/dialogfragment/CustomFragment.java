package jkammellander.dialogfragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * The CustomFragment class is a DialogFragment that displays a TextView and an EditText. When the user
 * clicks the OK button, the text in the EditText is sent to the MainActivity via the
 * MyCustomDialogListener interface
 */
public class CustomFragment extends DialogFragment {
    public static final String TAG = "MyDialogFragment";
    public MyCustomDialogListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_custom, container, false);
        // Setting an onClickListener on the OK button. When the user clicks the OK button, the text in
        // the EditText is sent to the MainActivity via the MyCustomDialogListener interface
        view.findViewById(R.id.ok_button).setOnClickListener(view1 -> {
            String textInput = ((TextView) view.findViewById(R.id.customDialogEditText)).getText().toString();
            listener.onFinishedDialog(textInput);
            dismiss();
        });
        return view;
}

    /**
     * When the view is created, set the text of the TextView to the text passed in the arguments.
     *
     * @param view The view that was created.
     * @param savedInstanceState This is the bundle that contains the saved state of the fragment.
     */
    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        assert getArguments() != null;
        ((TextView) view.findViewById(R.id.customTextView)).setText(getArguments().getString("text"));
    }

    /**
     * `onAttach()` is called when the fragment is attached to the activity
     *
     * @param context The context of the activity that is hosting the fragment.
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (MyCustomDialogListener) getActivity();
        } catch (ClassCastException e) {
            Log.e(TAG, "onAttach: ClassCastException: " + e.getMessage() );
        }
    }
}