package ado.fun.code.pseudonurse;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener {
Button bdoctor,bhospital,brelative1,brelative2,brelative3,bclear1,bclear2,bclear3,bclear4,bclear5;
    EditText doctor,hospital,relative1,relative2,relative3;
    String my_pref="contacts",num;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        pref = getApplicationContext().getSharedPreferences(my_pref, 0);
        editor=pref.edit();
        bdoctor=(Button)findViewById(R.id.bdoctor);
        bhospital=(Button)findViewById(R.id.bhospital);
        brelative1=(Button)findViewById(R.id.brelative1);
        brelative2=(Button)findViewById(R.id.brelative2);
        brelative3=(Button)findViewById(R.id.brelative3);
        bclear1=(Button)findViewById(R.id.bclear1);
        bclear2=(Button)findViewById(R.id.bclear2);
        bclear3=(Button)findViewById(R.id.bclear3);
        bclear4=(Button)findViewById(R.id.bclear4);
        bclear5=(Button)findViewById(R.id.bclear5);
        doctor=(EditText)findViewById(R.id.doctor);
        hospital=(EditText)findViewById(R.id.hospital);
        relative1=(EditText)findViewById(R.id.relative1);
        relative2=(EditText)findViewById(R.id.relative2);
        relative3=(EditText)findViewById(R.id.relative3);
        bdoctor.setOnClickListener(this);
        bhospital.setOnClickListener(this);
        brelative1.setOnClickListener(this);
        brelative2.setOnClickListener(this);
        brelative3.setOnClickListener(this);
        bclear1.setOnClickListener(this);
        bclear2.setOnClickListener(this);
        bclear3.setOnClickListener(this);
        bclear4.setOnClickListener(this);
        bclear5.setOnClickListener(this);
        update();
    }
    public void update()
    {
        pref = getApplicationContext().getSharedPreferences(my_pref, 0);
        editor=pref.edit();
        try
        {
            if(!pref.contains("doctor"))
            {
                doctor.setText("Enter number.");
            }
            else
            {
                num= pref.getString("doctor", "Enter number.");
                doctor.setText(num);
            }
            if(!pref.contains("hospital"))
            {
                hospital.setText("Enter number.");
            }
            else
            {
                num= pref.getString("hospital", "Enter number.");
                hospital.setText(num);
            }
            if(!pref.contains("relative1"))
            {
                relative1.setText("Enter number.");
            }
            else
            {
                num= pref.getString("relative1", "Enter number.");
                relative1.setText(num);
            }
            if(!pref.contains("relative2"))
            {
                relative2.setText("Enter number.");
            }
            else
            {
                num= pref.getString("relative2", "Enter number.");
                relative2.setText(num);
            }
            if(!pref.contains("relative3"))
            {
                relative3.setText("Enter number.");
            }
            else
            {
                num= pref.getString("relative3", "Enter number.");
                relative3.setText(num);
            }
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(),"your Preferences are not founded",Toast.LENGTH_SHORT).show();
        }
    }
    public void onClick(View v) {
        pref = getApplicationContext().getSharedPreferences(my_pref, 0);
        editor=pref.edit();
        String value="",key="";
        switch(v.getId())
        {
            case R.id.bdoctor:
                value=doctor.getText().toString().trim();
                key="doctor";break;
            case R.id.bhospital:
                value=hospital.getText().toString().trim();
                key="hospital";break;
            case R.id.brelative1:
                value=relative1.getText().toString().trim();
                key="relative1";break;
            case R.id.brelative2:
                value=relative2.getText().toString().trim();
                key="relative2";break;
            case R.id.brelative3:
                value=relative3.getText().toString().trim();
                key="relative3";break;
            case R.id.bclear1:
                key="hospital";
                editor.remove(key);
                editor.commit();
                update();
                Toast.makeText(getApplicationContext(),"The number is cleared.",Toast.LENGTH_SHORT).show();
                return;
            case R.id.bclear2:
                key="doctor";
                editor.remove(key);
                editor.commit();
                update();
                Toast.makeText(getApplicationContext(),"The number is cleared.",Toast.LENGTH_SHORT).show();
                return;
            case R.id.bclear3:
                key="relative1";
                editor.remove(key);
                editor.commit();
                update();
                Toast.makeText(getApplicationContext(),"The number is cleared.",Toast.LENGTH_SHORT).show();
                return;
            case R.id.bclear4:
                key="relative2";
                editor.remove(key);
                editor.commit();
                update();
                Toast.makeText(getApplicationContext(),"The number is cleared.",Toast.LENGTH_SHORT).show();
                return;
            case R.id.bclear5:
                key="relative3";
                editor.remove(key);
                editor.commit();
                update();
                Toast.makeText(getApplicationContext(),"The number is cleared.",Toast.LENGTH_SHORT).show();
                return;
        }
        String regex="\\d+";
        if(!(value.matches(regex)))
        {
            Toast.makeText(getApplicationContext(),"Please enter the number correctly."+value,Toast.LENGTH_SHORT).show();
            update();return;
        }
        if(value.length()!=10)
        {
            Toast.makeText(getApplicationContext(),"The number could not be updated.",Toast.LENGTH_SHORT).show();
            update();return;
        }
        editor.remove(key);
        editor.putString(key,value);
        editor.commit();
        Toast.makeText(getApplicationContext(),"The number is updated.",Toast.LENGTH_SHORT).show();
       update();
    }
}
