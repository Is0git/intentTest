package com.android.intenttests;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        Button button;
        EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        if(getIntent().hasExtra("Real")) {
            if(getIntent().getExtras().getString("Real").equals( "WORKED"))
            Toast.makeText(this, "TEST: " + getIntent().getExtras().getString("Real"), Toast.LENGTH_SHORT).show();
        }
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_VIEW);
//                intent.putExtra("Real", editText.getText().toString());
//                intent.setData(Uri.parse("something://"+getPackageName()));
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    intent.setType("video/*");
                if(intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, 0);
                }
            }
        });

    }
}
