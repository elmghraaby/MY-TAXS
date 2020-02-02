package com.elmaghraby.android;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

/******************************************************************************
 Copyright (c) 2020, Created By Ahmed Alaa Elmaghraby.                        *
 ******************************************************************************/

public class MessageDialogFragment extends DialogFragment {
    private View view;
    private Animation animScaleOut;
    private Animation fadeIn;
    private TextView messageTextView, okTextView;
    private String messageString;

    public static MessageDialogFragment newInstance(String messageString) {
        Bundle args = new Bundle();
        MessageDialogFragment fragment = new MessageDialogFragment();
        fragment.messageString = messageString;
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int title = getArguments().getInt("title");

        return new AlertDialog.Builder(getActivity())
                .setPositiveButton("ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                            }
                        }
                )
                .setMessage(messageString)
                .create();
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
