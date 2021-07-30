package android.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
 EditText editEmail,editPass ;
 Button sbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editEmail=(EditText)findViewById(R.id.editTextEmail);
        editPass=(EditText)findViewById(R.id.editTextPassword);
        sbtn=(Button)findViewById(R.id.signUpbtn);
        sbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = editEmail.getText().toString();
                String Password = editPass.getText().toString();
                if(!isValidPassword(Password)){
                    Toast.makeText(MainActivity.this,"Password doesn't match the rules",Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                intent.putExtra("email",Email);
                intent.putExtra("password",Password);
                startActivity(intent);
            }
        });
    }
    Pattern lowercase=Pattern.compile("^.*[a-z].*$");
    Pattern uppercase=Pattern.compile("^.*[A-Z].*$");
    Pattern numbers=Pattern.compile("^.*[0-9].*$");
    Pattern specialchar=Pattern.compile("^.*[^a-zA-Z0-9].*$");
    private Boolean isValidPassword(String password) {
        if(password.length()<8)
            return false;
        if(!lowercase.matcher(password).matches())
            return false;
        if(!uppercase.matcher(password).matches())
            return false;
        if(!numbers.matcher(password).matches())
            return false;
        if(!specialchar.matcher(password).matches())
            return false;

        return true;
    }
}