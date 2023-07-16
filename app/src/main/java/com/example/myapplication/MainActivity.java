package com.example.myapplication;

import static com.example.myapplication.R.id.Restart;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,resart;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    boolean flag=false;
    int count=0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.button1);
        btn2=findViewById(R.id.button2);
        btn3=findViewById(R.id.button3);
        btn4=findViewById(R.id.button4);
        btn5=findViewById(R.id.button5);
        btn6=findViewById(R.id.button6);
        btn7=findViewById(R.id.button7);
        btn8=findViewById(R.id.button8);
        btn9=findViewById(R.id.button9);
        resart=findViewById(R.id.Restart);
        resart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newGame();
            }
        });





    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert!");
        builder.setMessage("Are you sure want to exit ?");
        builder.setPositiveButton("Yes",(DialogInterface.OnClickListener)(dialog,which)->{
            finish();
        });
        builder.setNegativeButton("No",(DialogInterface.OnClickListener)(dialog,which)->{
            dialog.cancel();
        });
        AlertDialog alertDialog= builder.create();
        alertDialog.show();
    }

    public void Check(View view){
        Button btnCur= (Button) view;
        if(btnCur.getText().toString().equals("")){
            count++;
            if(!flag){
                btnCur.setText("X");
                flag=true;
            }
            else{
                btnCur.setText("0");
                flag=false;
            }
            if(count>=5){
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                if(b1.equals(b2) && b1.equals(b3) && !b1.equals("")){
                    win(b1);
                }
                else if(b4.equals(b5) && b4.equals(b6) && !b4.equals("")){
                    win(b4);
                }
                else if(b7.equals(b8) && b7.equals(b8) && !b7.equals("")){
                    win(b7);
                }
                else if(b1.equals(b4) && b1.equals(b7) && !b1.equals("")){
                    win(b1);
                }
                else if(b2.equals(b5) && b2.equals(b8) && !b2.equals("")){
                    win(b2);
                }
                else if(b3.equals(b6) && b3.equals(b9) && !b3.equals("")){
                    win(b3);
                }
                else if(b1.equals(b5) && b1.equals(b9) && !b1.equals("")){
                    win(b1);
                }
                else if(b3.equals(b5) && b3.equals(b7) && !b3.equals("")){
                    win(b3);
                }
                else{
                    if(count==9){
                        Toast.makeText(this, "Game is drawn.\nPlease ReStart the Game.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }
    }
    void newGame(){
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        count=0;
        flag=false;
//        btn2.setText("");

    }
    void win(String s){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Congrats");
        builder.setMessage(s+" is Winner.");
        builder.setPositiveButton("Restart",(DialogInterface.OnClickListener)(dialog, which)->{
            newGame();
        });
        builder.setNegativeButton("Exit",(DialogInterface.OnClickListener)(dialog, which)->{
            finish();
        });
        AlertDialog alertDialog= builder.create();
        alertDialog.show();
//        Toast.makeText(this,s+" is winner",Toast.LENGTH_SHORT).show();
        sleep();

    }

    void sleep(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                newGame();
            }
        },1500);
    }
}