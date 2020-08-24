package com.example.girlsshopping.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.girlsshopping.R;

public class DialogMail extends DialogFragment {

    int setMessage;
    int mesageText;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        setMessage=R.string.message;
        mesageText=R.string.messageText;

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setIcon(R.mipmap.star_foreground);
        builder.setTitle(setMessage);
        builder.setMessage(mesageText);
        builder.setCancelable(false);


        builder.setPositiveButton(R.string.send, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(getContext(), R.string.message_correct, Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog alertDialog=builder.create();
        return alertDialog;


    }
}
