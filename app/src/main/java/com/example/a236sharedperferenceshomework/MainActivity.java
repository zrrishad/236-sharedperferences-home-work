package com.example.a236sharedperferenceshomework;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edName,edEmail,edStudent,edNid;

    Button bButton;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edName=findViewById(R.id.edName);
      edEmail=findViewById(R.id.edEmail);
        edNid=findViewById(R.id.edNid);
        edStudent=findViewById(R.id.edStudent);
        bButton=findViewById(R.id.bButton);

        sharedPreferences=getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);
        editor=sharedPreferences.edit();


     bButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             String name=edName.getText().toString();
             String email=edEmail.getText().toString();
             String nid=edNid.getText().toString();
             String student=edStudent.getText().toString();



             editor.putString("username",""+name);
             editor.putString("useremail",email);
             editor.putString("usernid",nid);
             editor.putString("userstudent",student);



editor.apply();
             edName.setText("");








         }
     });

        String name=sharedPreferences.getString("username","default value");
        String email=sharedPreferences.getString("useremail","default value");
        String nid=sharedPreferences.getString("usernid","default value");
        String student=sharedPreferences.getString("userstudent","default value");


        edName.setText(name);
        edEmail.setText(email);
        edNid.setText(nid);
        edStudent.setText(student);











        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}