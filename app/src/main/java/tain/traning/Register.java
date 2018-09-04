package tain.traning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.fourhcode.forhutils.FUtilsValidation;

import java.util.HashMap;
import java.util.List;

import tain.traning.Model.*;
import tain.traning.Model.City;
import tain.traning.Presenter.LoginPrestener;
import tain.traning.Views.RegisterView;
import tain.traning.Views.cityview;

/**
 * Created by HP on 21/07/2018.
 */

public class Register extends Activity implements RegisterView,cityview {
    LoginPrestener userPresenter,userpresenter2;
    EditText address,mail,name,phone,password;
    CheckBox maleCheckBox,femaleCheckBox;
    Button register;
    String gender;
    Spinner spCountry;
    HashMap<Integer,String> spinnerMap = new HashMap<Integer, String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        address=findViewById(R.id.address);
        mail=findViewById(R.id.mail);
        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone);
        password=findViewById(R.id.password);
        register=findViewById(R.id.register);
        maleCheckBox=findViewById(R.id.checkmale);
        femaleCheckBox=findViewById(R.id.checkfmale);
        spCountry=findViewById(R.id.spCountry);

        maleCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender="0";
                femaleCheckBox.setChecked(false);
            }
        });
        femaleCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender="1";
                maleCheckBox.setChecked(false);
            }
        });


        userPresenter=new LoginPrestener(this,(RegisterView) this);
        userpresenter2=new LoginPrestener(this,(cityview) this);
        userpresenter2.getCeties();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FUtilsValidation.isEmpty(address, "please insert Address");
                FUtilsValidation.isEmpty(mail, "please insert Mail");
                FUtilsValidation.isEmpty(name, "please insert Name");
                FUtilsValidation.isEmpty(phone,"please insert Phone");
                FUtilsValidation.isEmpty(password, "please insert Password");
                FUtilsValidation.isLengthCorrect(password.getText().toString(), 8, 16);

                if (!FUtilsValidation.isLengthCorrect(password.getText().toString(), 8, 16))
                    password.setError("password min 8 char");

                if (!address.getText().toString().equals("") && !mail.getText().toString().equals("") && !name.getText().toString().equals("") && !phone.getText().toString().equals("") &&
                        (maleCheckBox.isChecked() || femaleCheckBox.isChecked())&& FUtilsValidation.isLengthCorrect(password.getText().toString(), 8, 16))
                {
                    User user = new User();
                    City city=new City();
                    user.setAddress(address.getText().toString());
                    user.setMail(mail.getText().toString());
                    user.setName(name.getText().toString());
                    user.setPhone(phone.getText().toString());
                    user.setPassword(password.getText().toString());
                    user.setGender(gender);
                    city.setId(Integer.valueOf(spinnerMap.get(spCountry.getSelectedItemPosition())));

                    userPresenter.register(user,city);
                }
            }
        });

    }
    @Override
    public void openMain() {
        Intent intent=new Intent(Register.this,MainActivity.class);
        startActivity(intent);
        Toast.makeText(this, "truee", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this,error,Toast.LENGTH_LONG);
    }

    @Override
    public void showlistcites(List<City> cites) {
        String[] spinnerArray = new String[cites.size()];

        for (int i = 0; i < cites.size(); i++)
        {
            spinnerMap.put(i,cites.get(i).getId().toString());
            spinnerArray[i] = cites.get(i).getEnglishName();
        }

        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCountry.setAdapter(adapter);

    }
}
