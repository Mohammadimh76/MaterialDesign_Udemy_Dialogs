package com.example.udemydialogs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    //type 1 - Alert Dialog

//    AlertDialog alertDialog;
//    AlertDialog.Builder builder;


    //type 2 - Confirmation Dialog
//
//    AlertDialog dialog;
//    AlertDialog.Builder builder;
//    String [] items = {"Easy", "Medium", "Hard", "Very Hard"};
//    String result = "";


    //type 3 - Progress Dialog
//    ProgressDialog dialog;


    //type 4 - Linear Progress Dialog
    ProgressDialog dialog;

    Handler handler;
    Runnable runnable;
    Timer timer;
    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


/////////////////////////...............Alert Dialog..............\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        //type 1 - Alert Dialog

//        builder = new AlertDialog.Builder(MainActivity.this,R.style.AlertDialogTheme);
//
//        builder.setMessage("Discard draft ?");
//
//        builder.setPositiveButton("DISCARD", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(MainActivity.this, "Discard click", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(MainActivity.this, "Cancel click", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        alertDialog = builder.create();
//
//        alertDialog.show();


//        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.colorAlertDialog));

//        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.colorAlertDialog));




        /////////////////////////...............Confirmation Dialog..............\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


    //type 2 - Confirmation Dialog

//        builder = new AlertDialog.Builder(MainActivity.this,R.style.ConfirmationDialogTheme);
//
//        builder.setTitle("selected the difficulty level");
//
//        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//
//                result = items[i];
//
////                switch (i){
////                    case 0:
////                        Toast.makeText(MainActivity.this, "Easy", Toast.LENGTH_SHORT).show();
////                        break;
////                    case 1:
////                        Toast.makeText(MainActivity.this, "Medium", Toast.LENGTH_SHORT).show();
////                        break;
////                    case 2:
////                        Toast.makeText(MainActivity.this, "Hard", Toast.LENGTH_SHORT).show();
////                        break;
////                    case 3:
////                        Toast.makeText(MainActivity.this, "Very Hard", Toast.LENGTH_SHORT).show();
////                        break;
////
////                }//The last switch
//
//            }
//        });
//
//
//
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(MainActivity.this,result, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(MainActivity.this, "Cancel click", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//        dialog = builder.create();
//
//        dialog.show();



        /////////////////////////...............Progress Dialog..............\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        //type 3 - Progress Dialog

//        dialog = new ProgressDialog(MainActivity.this,R.style.ProgressDialogTheme);
//
//        dialog.setTitle("Progress Dialog");
//
//        dialog.setMessage("Please wait...");
//
//        dialog.show();
//
//        dialog.cancel();




        /////////////////////////...............Linear Progress Dialog..............\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


        //type 4 - Linear Progress Dialog

        dialog = new ProgressDialog(MainActivity.this,R.style.ProgressDialogTheme);

        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        dialog.setIndeterminate(false);

        dialog.setTitle("Progress Dialog");

        dialog.setMessage("Please wait...");

        dialog.show();

        dialog.setProgress(0);
        dialog.setMax(100);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                i = i+1;
                if (i<=100){
                    dialog.setProgress(i);
                }else {
                    timer.cancel();
                    dialog.cancel();
                    i = 0;
                }
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        },8000,150);





    }//The last method onCreate
}//The last Class MainActivity
