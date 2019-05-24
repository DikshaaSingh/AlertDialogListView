package com.example.alertdialoglistview;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String[] listItems;
    TextView textView;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.txt);
        btn=findViewById(R.id.btnclick);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create list of items
                listItems=new String[] {"Item1", "Item2", "Item3"};
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Choose an Item");
                builder.setIcon(R.drawable.icon);
                builder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        textView.setText(listItems[i]);
                        dialog.dismiss();
                    }
                });
                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
    }


}
