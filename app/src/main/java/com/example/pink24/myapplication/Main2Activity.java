package com.example.pink24.myapplication;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {

    private TextView textView;
    private Button read;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        read=findViewById(R.id.read);
        textView=findViewById(R.id.textview);
    final DbHelper dbHelper= new DbHelper(this);
    read.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Cursor cursor= dbHelper.getData();
            StringBuilder stringBuilder=new StringBuilder();
            while (cursor.moveToNext()){
                stringBuilder.append("Id "+cursor.getString(0)+"\n");
                stringBuilder.append("Name "+cursor.getString(1)+"\n");
                stringBuilder.append("age "+cursor.getString(2)+"\n");
            }
            textView.setText(stringBuilder);
        }
    });


    }
}
