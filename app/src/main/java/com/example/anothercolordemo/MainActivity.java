package com.example.anothercolordemo;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Get color name from the input field and set the background of the output to that color
         * @param view
         */
    }
    public void submitColor (View view) {
        EditText input = findViewById(R.id.color_name_input);
        String name = input.getText().toString().toLowerCase() ;
        setColorByName(name);
    }

    /**
     * Sets the background color of the output field
     * @param name
     */
    private void setColorByName(String name) {

        int colorID = getResources().getIdentifier(name, "color", this.getPackageName());

        if (colorID != 0) {
            int color = ContextCompat.getColor(this, colorID);

            findViewById(R.id.output).setBackgroundColor(color);

    } else {

        Toast.makeText(this,"Color not found", Toast.LENGTH_SHORT).show();
        }
    }

}
