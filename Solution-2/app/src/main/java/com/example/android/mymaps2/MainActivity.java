/**
 * Created by nikhil on 2/26/16.
 */
package com.example.android.mymaps2;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    DatabaseHelper helper_db = new DatabaseHelper(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //method for Login
    public void onLoginClick(View view){
        EditText uname_raw = (EditText)findViewById(R.id.TFusername);
        String uname = uname_raw.getText().toString();
        EditText password_raw = (EditText)findViewById(R.id.TFpassword);
        String password = password_raw.getText().toString();

        String db_password = helper_db.userAuth(uname);

        if(password.equals(db_password)){
            Intent intent = new Intent(this, Map.class);
            intent.putExtra("Username", uname); //example for passing variables between screens
            startActivity(intent);
        }
        else{
            Toast.makeText(this,"The Username & Password don't match!!", Toast.LENGTH_SHORT).show();
        }

    }

    //method for SignupNow
    public void onSignupNowClick(View view){
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }

}
