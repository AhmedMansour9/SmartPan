package tain.traning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tain.traning.Model.User;
import tain.traning.Presenter.LoginPrestener;
import tain.traning.Views.loginview;

public class MainActivity extends AppCompatActivity implements loginview {

  EditText edituser,password;
  Button btnfinish;
   LoginPrestener login;
    String passwor;
    String emai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edituser=findViewById(R.id.username);
        password=findViewById(R.id.password);
        btnfinish=findViewById(R.id.finish);
         login=new LoginPrestener(this,this);
        btnfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emai=edituser.getText().toString();
                passwor=password.getText().toString();

                login.login(emai,passwor);

            }
        });
    }

    @Override
    public void main(User user) {
        startActivity(new Intent(MainActivity.this,Categories.class));
    }

    @Override
    public void showerror() {
        Toast.makeText(this, "false",Toast.LENGTH_SHORT).show();
    }
}
