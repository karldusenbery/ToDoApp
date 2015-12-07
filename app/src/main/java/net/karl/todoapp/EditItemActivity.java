/*
@author John Karl Dusenbery <john.dusenbery@gmail.com>
@version 1.0
 */

package net.karl.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        //grabs the text from the previous activity set as an Intent Extra and places it as the text in the EditText box
        EditText editText = (EditText) findViewById(R.id.etEditText);
        Intent  i = getIntent();
        String selectedText = i.getStringExtra("clickedItemText"); //creates a String passed from previous activity
        editText.setText(selectedText);
    }

    //action performed when save button is clicked
    public void onSaveEditItem(View view) {
        EditText etItem = (EditText) findViewById(R.id.etEditText);

        // Prepare data intent
        Intent data = new Intent();

        // Pass relevant data back as a result
        data.putExtra("editedTodoItem", etItem.getText().toString());

        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response

        finish(); // closes the activity, pass data to parent
    }
}
