package com.example.pascual_michaeljordan_courseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @SuppressLint("StaticFieldLeak")
    static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DialogFragment loginFragment = new LoginDialogFragment();
        loginFragment.show(getFragmentManager(), "login");

        context = this;

    }

    @SuppressLint("ValidFragment")
    public class LoginDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View v = inflater.inflate(R.layout.activity_login, null);
            final EditText etUsername = v.findViewById(R.id.username);
            final EditText etPassword = v.findViewById(R.id.password);
            builder.setView(v);
            builder.setPositiveButton(R.string.login, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                    String username, password;
                    username = etUsername.getText().toString();
                    password = etPassword.getText().toString();
                    String msg;
                    if (username.equalsIgnoreCase("abcd") && password.equalsIgnoreCase("1234")) {
                        msg = "Access Granted";

                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();

                    } else {
                        msg = "Access Denied!";
                    }
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            return builder.create();
        }
    }

}