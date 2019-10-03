package com.example.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;

public class HomeActivity extends AppCompatActivity {
    ToggleButton nappi;
    EditText kentta;

    private static final String KEY_INPUT = "input_key";
    private static final String KEY_BUTTON = "button_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        nappi = (ToggleButton)findViewById(R.id.nappi);
        kentta = (EditText)findViewById(R.id.kentta);

        if(savedInstanceState != null) {
            nappi.setChecked(savedInstanceState.getBoolean(KEY_BUTTON));
            kentta.setText(savedInstanceState.getString(KEY_INPUT));
            kentta.setEnabled(savedInstanceState.getBoolean(KEY_BUTTON));
        }
        nappi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nappi.isChecked()){
                    kentta.setEnabled(true);
                } else {
                    kentta.setEnabled(false);
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(KEY_INPUT, kentta.getText().toString());
        savedInstanceState.putBoolean(KEY_BUTTON, nappi.isChecked());

        super.onSaveInstanceState(savedInstanceState);
    }
}
