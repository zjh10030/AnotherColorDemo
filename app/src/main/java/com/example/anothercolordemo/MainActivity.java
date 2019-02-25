package com.example.anothercolordemo;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListener();
    }
    private void addListener(){
        EditText.OnEditorActionListener listener = new EditText.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionID, KeyEvent event) {
                if (actionID == EditorInfo.IME_ACTION_DONE){
                    submitColor(null);

                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(),0);

                    return true;
                }

                return false;

            }
        };

       EditText input = findViewById(R.id.color_name_input);
        input.setOnEditorActionListener(listener);

        /**
         * Get color name from the input field and set the background of the output to that color
         * @param view
         */
    }
    public void submitColor (View view) {
        EditText input = findViewById(R.id.color_name_input);
        String name = input.getText().toString().toLowerCase();
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

    public void randomColor(View view) {
        String[] colors = getResources().getStringArray(R.array.colors);

        int whichColor = (int) (colors.length * Math.random());

        setColorByName(colors[whichColor]);
    }
}
