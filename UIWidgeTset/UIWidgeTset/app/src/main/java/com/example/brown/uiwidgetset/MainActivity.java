package com.example.brown.uiwidgetset;

<<<<<<< HEAD
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
=======
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
>>>>>>> 2f3d899abc6bbec256e79370e305ef507ae98483
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
<<<<<<< HEAD
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button button;
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;
=======

public class MainActivity extends AppCompatActivity {

    private Button button;
>>>>>>> 2f3d899abc6bbec256e79370e305ef507ae98483

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        button = (Button) findViewById(R.id.button);
<<<<<<< HEAD
        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String intputText = editText.getText().toString();
//                Toast.makeText(MainActivity.this,intputText,Toast.LENGTH_SHORT).show();
//                imageView.setImageResource(R.drawable.dog);
//                if(progressBar.getVisibility() == View.GONE){
//                    progressBar.setVisibility(View.VISIBLE);
//                } else {
//                    progressBar.setVisibility(View.GONE);
//                }
//                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//                dialog.setTitle("This is a AlertDialog");
//                dialog.setMessage("Something important.");
//                dialog.setCancelable(false);
//                dialog.setPositiveButton("OK",new DialogInterface.OnClickListener(){
//                    public void onClick(DialogInterface dialog,int which){
//                    }
//                });
//                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                    }
//                });
//                dialog.show();
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("This is a ProgressDialog");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
=======
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

>>>>>>> 2f3d899abc6bbec256e79370e305ef507ae98483
            }
        });


    }
}
