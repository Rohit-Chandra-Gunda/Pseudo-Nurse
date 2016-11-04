package ado.fun.code.pseudonurse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
public class DietActivity extends AppCompatActivity {
    String diets[]={"The diet needed to maintain good health as follows:","Base your meals on starchy foods: bread, potatoes, pasta, rice, noodles  Choose whole grains and potatoes with skin where possible which havemore fibre, vitamins and minerals.","•\tEat lots of fruit and veg       Choose a variety of fruit and vegetables as they contain different combinations of vitamins and minerals.","Eat egg every day","•\tEat more fish - aim for at least two portions per week and one of these should be oily.","Cut down on saturated fat and sugar.","•\tEat less salt, adults should eat no more than 6 g per day and children should have even less.","Don’t get thirsty.\nAim for 8-10 glasses of fluid per day.","Don’t skip breakfast.","Get active and be a healthy weight!\nModerate intensity activities include cycling or brisk walking.\n High or vigorous intensity activities include swimming and running.\n Muscle strengthening activities include weight lifting, exercises with weights or carrying heavy boxes or groceries.\nPhysical activity can reduce the risk of type 2 diabetes, heart disease and stroke and help maintain a healthy weight."};
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, diets);
        lv = (ListView) findViewById(R.id.dietlist);
        lv.setAdapter(adapter);
    }
}
