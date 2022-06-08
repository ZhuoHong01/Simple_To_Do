package sg.edu.rp.c346.id21018193.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity1 extends AppCompatActivity {

    EditText taskDelete;
    TextView tvAdd;
    Button btnDelete;
    Button btnClear;
    ListView lvTasks;
    ArrayList<Integer> alTasks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        tvAdd = findViewById(R.id.textViewAdd);
        taskDelete = findViewById(R.id.editTextTaskDelete);
        btnDelete = findViewById(R.id.buttonDelete);
        btnClear = findViewById(R.id.buttonClear);
        lvTasks = findViewById(R.id.listViewTasks);
        alTasks = new ArrayList<Integer>();

        ArrayAdapter aaTask = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, alTasks);
        lvTasks.setAdapter(aaTask);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(alTasks.size() >= 1){
                    String taskPosition = taskDelete.getText().toString();
                    alTasks.remove(taskPosition);
                    aaTask.notifyDataSetChanged();
                }
                else {
                    Toast.makeText(Activity1.this, "There is no task to delete",Toast.LENGTH_SHORT);
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alTasks.clear();
                aaTask.notifyDataSetChanged();
            }
        });

        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity1.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}