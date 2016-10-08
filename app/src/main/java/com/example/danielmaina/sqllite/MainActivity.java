package com.example.danielmaina.sqllite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyDBHandler dbHandler;
    TextView myTextView;
    EditText myEditext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myEditext = (EditText) findViewById(R.id.myEditText);
        myTextView = (TextView) findViewById(R.id.myTextView);

        dbHandler = new MyDBHandler(this, null,null, 1);
        printDatabase();
    }





    //onClick method to add a product to the database
    public void addButtonClicked(){
        Products product = new Products(myEditext.getText().toString());
        dbHandler.addProduct(product);
    }
    //Delete button onClick method
    public void deleteButtonClicked(View view){
        String inputText = myTextView.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();

    }








    public void printDatabase (){
        String dbString = dbHandler.databaseToString();
        myTextView.setText(dbString);
        myEditext.setText("");
    }
}
