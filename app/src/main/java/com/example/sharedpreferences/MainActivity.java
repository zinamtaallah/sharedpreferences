package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private String mPreferences;
    private SharedPreferences.Editor mEditor;
    private EditText Name,Password;
    private Button Login;
    private CheckBox CheckBox;

    @RequiresApi(api = Build.VERSION_CODES.N)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=findViewById(R.id.Name);
        Password=findViewById(R.id.Password);
        Login=findViewById(R.id.btn_login);
        CheckBox=findViewById(R.id.checkbox);


        mPreferences= PreferenceManager.getDefaultSharedPreferencesName(this);

        // mPreferences=getSharedPreferences("tabian.com.sharedpreferencestest", Context.MODE_PRIVATE);
        mEditor=mPreferences.edit();
        checkboxSharedPreferences();
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheckBox.isChecked()){
                    mEditor.putString(getString(R.string.checkbox),"true");
                    mEditor.commit();
                    //save the name
                    String name =Name.getText().toString();
                    mEditor.putString(getString(R.string.name),name);
                    mEditor.commit();
                    //save password
                    String password =Name.getText().toString();
                    mEditor.putString(getString(R.string.password),password);
                    mEditor.commit();


                }else {
                    mEditor.putString(getString(R.string.checkbox),"False");
                    mEditor.commit();
                    //save the name

                    mEditor.putString(getString(R.string.name),"");
                    mEditor.commit();
                    //save password

                    mEditor.putString(getString(R.string.password),""); 
                    mEditor.commit();


                }
            }
        });

    }
    private void checkboxSharedPreferences(){
        String checkbox =mPreferences.getString((R.string.checkbox),"False");
        String name =mPreferences.getString(getString(R.string.name),"");
        String password =mPreferences.getString(getString(R.string.password),"");
        Name.setText(name);
        Password.setText(password);
        if (checkbox.equals("true")){
            CheckBox.setChecked(true);

        }else {
            CheckBox.setChecked(false);
        }
    }
}