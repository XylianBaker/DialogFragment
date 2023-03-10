package jkammellander.dialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

/**
 * `StandardFragment` is a `DialogFragment` that displays a message in an `AlertDialog` and has an "OK"
 * button
 */
public class StandardFragment extends DialogFragment {
   public static String TAG = "MyDialogFragment";

   @NonNull
   @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
       assert getArguments() != null;
       return new AlertDialog.Builder(requireContext())
                // set the message from the text argument
                .setMessage(getArguments().getString("text"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Do nothing
                    }
                })
                .create();
    }

}