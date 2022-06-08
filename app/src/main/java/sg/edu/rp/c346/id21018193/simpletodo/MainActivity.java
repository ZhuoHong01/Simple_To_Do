package sg.edu.rp.c346.id21018193.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spnTasks;
    EditText tasks;
    Button btnAdd;
    Button btnDelete;
    Button btnClear;
    ListView lvTasks;
    ArrayList<String> alTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnTasks = findViewById(R.id.spinner);
        tasks = findViewById(R.id.editTextTask);
        btnAdd = findViewById(R.id.buttonAdd);
        btnDelete = findViewById(R.id.buttonDelete);
        btnClear = findViewById(R.id.buttonClear);
        lvTasks = findViewById(R.id.listViewTasks);
        alTasks = new ArrayList<>();

        ArrayAdapter aaTask = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, alTasks);
        lvTasks.setAdapter(aaTask);

        spnTasks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        if(spnTasks.getSelectedItem() == "Add Tasks"){
                            btnAdd.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    String taskName = tasks.getText().toString();
                                    alTasks.add(taskName);
                                    aaTask.notifyDataSetChanged();
                                }
                            });

                            btnDelete.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                }
                            });

                            btnClear.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    alTasks.clear();
                                    aaTask.notifyDataSetChanged();
                                }
                            });
                        }

                    case 1:
                        if(spnTasks.getSelectedItem() == "Add Tasks"){
                            btnAdd.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                }
                            });
                            btnDelete.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    Integer taskPos = tasks.getId();
                                    alTasks.remove(taskPos);
                                    aaTask.notifyDataSetChanged();
                                }
                            });

                            btnClear.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    alTasks.clear();
                                    aaTask.notifyDataSetChanged();
                                }
                            });
                        }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}