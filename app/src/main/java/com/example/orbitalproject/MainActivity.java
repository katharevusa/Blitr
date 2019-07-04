package com.example.orbitalproject;


import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etDate, etAmount, etID, etPax;
    Button btnAdd, btnView, btnViewUpdate,btnDelete;
    DatabaseHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etAmount = (EditText) findViewById(R.id.et_amount);
        etName = (EditText) findViewById(R.id.et_event_name);
        etDate = (EditText) findViewById(R.id.et_date);
        etID = (EditText) findViewById(R.id.et_id);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnView = (Button) findViewById(R.id.btnView);
        btnViewUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        myDB = new DatabaseHelper(this);
        AddData();
        viewAll();
        UpdateData();
        DeleteData();

    }

    public void UpdateData(){
        btnViewUpdate.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        boolean isUpdate = myDB.updateData(etID.getText().toString(),etName.getText().toString(),
                                etDate.getText().toString(),etAmount.getText().toString());
                        if(isUpdate == true){
                            Toast.makeText(MainActivity.this,"Transaction is updated",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(MainActivity.this,"Transaction is not updated",Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
    public void viewAll(){
        btnView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res = myDB.getListContents();
                        if (res.getCount() == 0) {
                            showMessage("Error", "Nothing found");
                            //show message
                            return;
                        }
                        Intent intent = new Intent(MainActivity.this, ViewListContents.class);
                        startActivity(intent);

                    }
                });
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void AddData () {
        btnAdd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = myDB.addData(etName.getText().toString(),
                                etDate.getText().toString(),
                                etAmount.getText().toString());
                        if (isInserted == true) {
                            Toast.makeText(MainActivity.this, "Successfully Entered Data!", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Something went wrong :(.", Toast.LENGTH_LONG).show();

                        }
                    }
                }
        );
    }
    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDB.deleteData(etID.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(MainActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}

