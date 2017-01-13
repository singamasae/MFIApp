package com.project.mfi.app;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu4);
    }

    public void onClickNext(View view) {
        setContentView(R.layout.activity_menu4_2);

        ListView list_detail = (ListView) findViewById(R.id.list_detail);

        String[] values = new String[] {"Name : Mr. Rudy","Address : Bali Indonesia"," Information : Your detail transaction goes here..."};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, values);
        list_detail.setAdapter(adapter);
    }

    public void onClickSubmit(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Information");
        builder.setMessage("Transaction is successful");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.show();
    }
}
