package com.example.pink24.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button go;
    private EditText nametext;
    private EditText agetext;
    private Button save;
    private Button update;
    private EditText idtext;
    private Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        go=findViewById(R.id.go);
        save=findViewById(R.id.save);
        nametext=findViewById(R.id.name);
        agetext=findViewById(R.id.age);
        update=findViewById(R.id.update);
        idtext=findViewById(R.id.id);
        delete=findViewById(R.id.delete);

final  DbHelper dbHelper= new DbHelper(this);


save.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String name= nametext.getText().toString();
        String age = agetext.getText().toString();
        if(dbHelper.myInsert(name, age)){
            Toast.makeText(MainActivity.this, "save",Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(MainActivity.this, "error",Toast.LENGTH_SHORT).show();
        }
    }
});

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name= nametext.getText().toString();
                String age = agetext.getText().toString();
                String id=idtext.getText().toString();
                dbHelper.update(id,name,age);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=idtext.getText().toString();
                dbHelper.delete(id);
            }
        });


    }
}
