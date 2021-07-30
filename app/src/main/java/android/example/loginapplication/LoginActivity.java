package android.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText emailEditText, passwordEditText;
    Button loginBtn;
    int counter=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailEditText = (EditText)findViewById(R.id.editEmail);
        passwordEditText=(EditText)findViewById(R.id.editpass);
        loginBtn=(Button)findViewById(R.id.loginbtn);
        String RegisteredEmail=getIntent().getStringExtra("email");
        String RegisteredPassword=getIntent().getStringExtra("password");
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailEditText.getText().toString();
                String password=passwordEditText.getText().toString();
                if(RegisteredEmail.equals(email)&&RegisteredPassword.equals(password))
                {
                    Intent intent=new Intent(LoginActivity.this,LoginSucess.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Credentials doesn't match try again",Toast.LENGTH_LONG).show();
                }
                counter--;
               if(counter==0){
                   Toast.makeText(LoginActivity.this,"Max Attempt Reached",Toast.LENGTH_LONG).show();
                   loginBtn.setEnabled(false);
               }
            }
        });
    }
}