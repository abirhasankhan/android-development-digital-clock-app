package edu.ewubd.assignment02_abir013;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    TextView textview;
    Button exit;
    Date today;
    SimpleDateFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = findViewById(R.id.textview);
        exit= findViewById(R.id.exit);
        
        exit.setOnClickListener(v -> funExit());

        blink();
    }

    private void funExit() {
        this.finishAffinity();
    }

    private void blink() {
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(550);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        today = new Date();
                        formatter = new SimpleDateFormat("hh:mm:ss");
                        textview.setText(formatter.format(today));
                        blink();
                    }
                });
            }
        }).start();
    }
}
