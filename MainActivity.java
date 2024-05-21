package com.example.dicegame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.os.PersistableBundle;
import java.util.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
   private Button button;
   private TextView textView, textView2, textView3;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       button = findViewById(R.id.button);
       textView = findViewById(R.id.textView);
       textView2 = findViewById(R.id.textView2);
       textView3 = findViewById(R.id.textView3);
       if (savedInstanceState != null) {
           String a = savedInstanceState.getString("a");
           String b = savedInstanceState.getString("b");
           String c = savedInstanceState.getString("c");
           textView.setText(b);
           textView2.setText(a);
           textView3.setText(c);
       }
       button.setOnClickListener(new View.OnClickListener(){
                                @Override
                                public void onClick(View view){
                                    Toast.makeText(MainActivity.this, "Dice Rolled!", Toast.LENGTH_SHORT).show();
                                    Random rand = new Random();
                                    int a=rand.nextInt(6)+1;
                                    int b=rand.nextInt(6)+1;
                                    textView.setText("Player 2 -> " + String.valueOf(a));
                                    textView2.setText("Player 1 -> " + String.valueOf(b));
                                    if(a<b){
                                        textView3.setText("Winner is Player 1" );
                                    }
                                    else if(a>b){
                                        textView3.setText("Winner is Player 2" );
                                    }
                                    else{
                                        textView3.setText("It's a tie!" );
                                    }
                                }}
       );

   }
   @Override
   protected void onSaveInstanceState(Bundle outState) {
       super.onSaveInstanceState(outState);
       // Save the current values of the TextViews
       outState.putString("a",(textView.getText().toString()));
       outState.putString("b", (textView2.getText().toString()));
       outState.putString("c", (textView3.getText().toString()));
   }


}
