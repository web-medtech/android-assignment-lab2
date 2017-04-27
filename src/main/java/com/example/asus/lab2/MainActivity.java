package com.example.asus.lab2;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    String[] grades = {"12", "18", "4.5", "20", "16", "13", "8"};
    String[] studentsNames = {"Fatma", "Omar", "Chayma", "Soumaya", "Souad"};
    HashMap<String, String[]> allGrades;
    ListView gradesList;
    AutoCompleteTextView students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gradesList = (ListView) findViewById(R.id.grades_list);
        students = (AutoCompleteTextView) findViewById(R.id.students);

        allGrades = new HashMap<>();
        allGrades.put("Chayma", new String[]{"12", "10", "15", "16", "13", "0"});
        allGrades.put("Omar", new String[]{"18", "18", "15", "16", "17", "20"});
        allGrades.put("Fatma", new String[]{"1", "18", "15", "16", "13", "0"});
        allGrades.put("Soumaya", new String[]{"12", "10", "15", "16", "13", "0"});
        allGrades.put("Souad", new String[]{"12", "10", "19", "1", "1", "0"});

        //gradesList = (ListView) findViewById(R.id.grades_list);

        // students = (AutoCompleteTextView) findViewById(R.id.students);
        //ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, studentsNames);
        //students.setAdapter(adapter2);


        // final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, grades);
        // gradesList.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, studentsNames);
        students.setAdapter(adapter2);

        gradesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView gradeView =(TextView) view.findViewById(R.id.grade);
                float grade = Float.valueOf(gradeView.getText().toString());
                if (grade >= 10) toast("pass");
                else toast("fail");
            }
        });


        //Autocomplete text view
        students.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String studentName = ((TextView) view).getText().toString();
                MyLineAdapter adapter = new MyLineAdapter(MainActivity.this,allGrades.get(studentName));
                gradesList.setAdapter(adapter);
            }
        });
    }

    public void toast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
