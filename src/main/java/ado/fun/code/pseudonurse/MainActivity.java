package ado.fun.code.pseudonurse;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import android.view.MenuItem;
import android.net.Uri;
import com.microsoft.windowsazure.mobileservices.*;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button manage,callhospital,messagedoctor,todo,know,diet,emergency;
    String contacts[]={"hospital","doctor","relative1","relative2","relative3"},emnum;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    String my_pref="contacts",num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),"Hello!Is everything fine?",Toast.LENGTH_LONG).show();
        manage=(Button) findViewById(R.id.manage);
        callhospital=(Button) findViewById(R.id.callhospital);
        messagedoctor=(Button) findViewById(R.id.messagedoctor);
        todo=(Button) findViewById(R.id.todo);
        know=(Button) findViewById(R.id.know);
        diet=(Button) findViewById(R.id.diet);
        emergency=(Button) findViewById(R.id.emergency);
        emergency.setOnClickListener(this);
        manage.setOnClickListener(this);
        know.setOnClickListener(this);
        todo.setOnClickListener(this);
        messagedoctor.setOnClickListener(this);
        callhospital.setOnClickListener(this);
        diet.setOnClickListener(this);
    }
    public void onClick(View v)
    {
        pref = getApplicationContext().getSharedPreferences(my_pref, 0);
        editor=pref.edit();
        Intent intent;
        switch(v.getId())
        {
            case R.id.messagedoctor:
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.putExtra("sms_body", "I need to book an appointment.");
                sendIntent.setType("vnd.android-dir/mms-sms");
                startActivity(sendIntent);
                break;
            case R.id.callhospital:
                if(!pref.contains("doctor"))
                {
                    Toast.makeText(getApplicationContext(),"No number stored for your doctor.",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    num= pref.getString("doctor", "Enter number.");
                }
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + num));
                try{
                    startActivity(intent);
                }

                catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(getApplicationContext(),"your Activity is not founded",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.manage:
                try {
                    intent = new Intent(MainActivity.this, ContactActivity.class);
                    startActivity(intent);
                }
                catch(Exception e)
                {
                    Toast.makeText(getApplicationContext(),"your Activity is not founded",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.know:
                intent=new Intent(MainActivity.this,DiseaseActivity.class);
                startActivity(intent);
                break;
            case R.id.diet:
                intent=new Intent(MainActivity.this,DietActivity.class);
                startActivity(intent);
                break;
            case R.id.todo:
                intent=new Intent(MainActivity.this,ToDoActivity.class);
                startActivity(intent);
                break;
            case R.id.emergency:
                SmsManager sms=SmsManager.getDefault();
                for(int i=0;i<=4;i++)
                {
                    if(pref.contains(contacts[i]))
                    {
                        emnum=pref.getString(contacts[i], "Enter number.");
                        sms.sendTextMessage(emnum, null, "Under Health Emergency!", null, null);
                        Toast.makeText(getApplicationContext(),"Message sent to."+emnum,Toast.LENGTH_SHORT).show();
                    }
                }
                if(!pref.contains("hospital"))
                {
                    Toast.makeText(getApplicationContext(),"No number stored for your hospital.",Toast.LENGTH_SHORT).show();return ;
                }
                else
                {
                    num= pref.getString("hospital", "Enter number.");
                }
                if(pref.contains("hospital"))
                {intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + num));
                try{
                    startActivity(intent);
                }

                catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(getApplicationContext(),"Calling hospital failed.",Toast.LENGTH_SHORT).show();
                }}
                break;
        }
    }
}
