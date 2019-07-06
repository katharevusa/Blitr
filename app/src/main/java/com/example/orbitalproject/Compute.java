package com.example.orbitalproject;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Compute extends AppCompatActivity {

    TextView tv;
    DatabaseHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compute);
        tv = (TextView) findViewById(R.id.price_tv);

        Bundle bundle = getIntent().getExtras();
        String a = bundle.getString("Cost");
        tv.setText(a);
    }
    /*public void UpdateData(){
        btnViewUpdate.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        boolean isUpdate = myDB.updateData(etID.getText().toString(),etName.getText().toString(),
                                etDate.getText().toString(),etAmount.getText().toString(),etPax.getText().toString());
                        if(isUpdate == true){
                            Toast.makeText(MainActivity.this,"Transaction is updated",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(MainActivity.this,"Transaction is not updated",Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }*/
}
