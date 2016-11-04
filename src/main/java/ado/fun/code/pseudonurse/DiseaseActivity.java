package ado.fun.code.pseudonurse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DiseaseActivity extends AppCompatActivity {
    String diseases[]={"Body pains","Head-Ache","Nausea and Vomittings","General Fever","Caugh and Cold","Stomach-Ache","Stomach-Infection\nSymptoms:vomiting, diarrhoea and stomach pain.","Viral Fever.\nSymptoms:mild to severe fever, along with cold and cough","Malaria.\nSymptoms:fever, shivers, muscle pain and weakness","Measles.\nSymptoms:high fever, cough, runny nose, sore throat and red eyes","Jaundice.\nSymptoms:yellow discoloration of the skin, mucous membranes and the whites of the eyes, light-colored stools, dark-colored urine and itching of the skin.","Thyphoid.\nSymptoms:fever, fatigue, weakness, pain in the abdomen,headache, loss of appetite, and sometimes a rash","Mumps.\nSymptoms:swelling up of salivary glands.","Chicken-Pox.\nSymptoms:itchy red rash like spots or boils all over the body","Cholera.\nSymptoms:o\tSudden onset of frequent, painless watery stools,Rapid Dehydration,Vomiting","Diarrhoea:There are two main types of diarrhoea – acute diarrhoea and chronic diarrhoea.. Both of these are highly preventable and treatable. In order to prevent this bowel problem, maintain proper hygiene, wash hands before handling food and drink only boiled water.","Influenza.\nSymptoms:o\tFever of at least 38C, Headache, Runny nose, Sore throat ,Cough ,Muscle or joint pains.","Dengue fever is potentially fatal and mainly affects children.","ChickunGunya.\nSymptoms:abrupt onset of fever.","Hepatitis-A.\nSymptoms:o\tFever,flu-like symptoms: weakness, muscle and joint aches, loss of appetite, dizziness (with or without vomiting), abdominal discomfort, after a few days, jaundice may follow.","Leprospirosis.\nSymptoms:o\tFever, Muscle pain, Headache, Calf-muscle pain and reddish eyes, For severe cases (liver/brain involvement or kidney failure), Yellowish body discoloration, Dark-colored urine, Light stools, Low urine output, Severe headache","Other Disease."};
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, diseases);
        lv = (ListView) findViewById(R.id.diseaselist);
        lv.setAdapter(adapter);

    }
}
