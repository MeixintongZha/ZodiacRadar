package com.example.thay.geopointsexample;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.thay.geopointsexample.horoscope.AquariusActivity;
import com.example.thay.geopointsexample.horoscope.AriesActivity;
import com.example.thay.geopointsexample.horoscope.CancerActivity;
import com.example.thay.geopointsexample.horoscope.CapricornActivity;
import com.example.thay.geopointsexample.horoscope.GeminiActivity;
import com.example.thay.geopointsexample.horoscope.LeoActivity;
import com.example.thay.geopointsexample.horoscope.LibraActivity;
import com.example.thay.geopointsexample.horoscope.PiscesActivity;
import com.example.thay.geopointsexample.horoscope.SagittariusActivity;
import com.example.thay.geopointsexample.horoscope.ScorpioActivity;
import com.example.thay.geopointsexample.horoscope.TaurusActivity;
import com.example.thay.geopointsexample.horoscope.VirgoActivity;
import com.parse.Parse;
import com.parse.ParseUser;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Parse.initialize(this);
        final Button button_users_activity = findViewById(R.id.button_users_activity);
        ParseUser User = ParseUser.getCurrentUser();
        String Zodiac = User.get("Zodiac").toString();
        AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this)
                .setTitle("Greeting")
                .setMessage("Hello, " + Zodiac)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
//                        Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
//                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                        startActivity(intent);
                    }
                });
        AlertDialog ok = builder.create();
        ok.show();



        button_users_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog dlg = new ProgressDialog(MenuActivity.this);
                dlg.setTitle("Please, wait a moment.");
                dlg.setMessage("Opening Menu...");
                dlg.show();

                Intent intent = new Intent(MenuActivity.this, MenuUsersActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });


        final Button logout_button = findViewById(R.id.logout_button);
        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // logging out of Parse
                ParseUser.logOut();
                alertDisplayer("So, you're going...", "Ok...Bye-bye then");
            }
        });

    }

    public void launchAriesActivity(View view) {
        Intent intent = new Intent(this, AriesActivity.class);
        startActivity(intent);
    }

    public void launchAquariusActivity(View view) {
        Intent intent = new Intent(this, AquariusActivity.class);
        startActivity(intent);
    }

    public void launchCancerActivity(View view) {
        Intent intent = new Intent(this, CancerActivity.class);
        startActivity(intent);
    }

    public void launchCapricornActivity(View view) {
        Intent intent = new Intent(this, CapricornActivity.class);
        startActivity(intent);
    }

    public void launchGeminiActivity(View view) {
        Intent intent = new Intent(this, GeminiActivity.class);
        startActivity(intent);
    }

    public void launchLeoActivity(View view) {
        Intent intent = new Intent(this, LeoActivity.class);
        startActivity(intent);
    }

    public void launchLibraActivity(View view) {
        Intent intent = new Intent(this, LibraActivity.class);
        startActivity(intent);
    }

    public void launchPiscesActivity(View view) {
        Intent intent = new Intent(this, PiscesActivity.class);
        startActivity(intent);
    }

    public void launchSagittariusActivity(View view) {
        Intent intent = new Intent(this, SagittariusActivity.class);
        startActivity(intent);
    }

    public void launchScorpioActivity(View view) {
        Intent intent = new Intent(this, ScorpioActivity.class);
        startActivity(intent);
    }

    public void launchTaurusActivity(View view) {
        Intent intent = new Intent(this, TaurusActivity.class);
        startActivity(intent);
    }

    public void launchVirgoActivity(View view) {
        Intent intent = new Intent(this, VirgoActivity.class);
        startActivity(intent);
    }

    private void alertDisplayer(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
        AlertDialog ok = builder.create();
        ok.show();
    }
}
