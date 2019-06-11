package com.example.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button changeSizeBtn,coin,help,about,activate;
    EditText editText;
    TextView textView;
    SeekBar seekBar;
    int seekBar_value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeSizeBtn = (Button)findViewById(R.id.button);
        changeSizeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View alertLayout = inflater.inflate(R.layout.dialog_change_size, null);
                final  EditText editText= alertLayout.findViewById(R.id.editText);
                final TextView textView = alertLayout.findViewById(R.id.textview);
                final TextView textView2 = alertLayout.findViewById(R.id.textView2);
                final SeekBar seekBar=alertLayout.findViewById(R.id.seekBar);

                LayoutInflater inflater1 = getLayoutInflater();
                View alertLayout1 = inflater1.inflate(R.layout.files, null);
                final TextView textView1 = alertLayout.findViewById(R.id.textView2);


                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        seekBar_value = progress;
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        String temp = "processing.......";
                        textView2.setText(temp);
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        textView2.setText(editText.getText().toString());
                        textView2.setTextSize(seekBar_value);
                    }
                });


                //openDialog();
                //  AlertDialog.Builder a = new AlertDialog.Builder()
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Info");
                // this is set the view from XML inside AlertDialog
                alert.setView(alertLayout);
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
                    }
                });

                alert.setPositiveButton("Done", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // String user = etUsername.getText().toString();
                        // String pass = etEmail.getText().toString();
                        //Toast.makeText(getBaseContext(), "Username: " + user + " Email: " + pass, Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = alert.create();
                dialog.show();

            }
        });
    }
}
