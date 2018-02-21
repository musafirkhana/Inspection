package com.vaiuu.baf.bafinspection;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {
    private String TAG = SplashActivity.class.getSimpleName();
    private TimerTask sostt;
    private final long period = 5000;
    private final int delay = 5000;
    private Timer sostimer;
    private Context context;

    private String text;
    private String respones_results;


    public static ProgressDialog progDialogConfirm;
    boolean flag = true;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        context = this;
        //mp=MediaPlayer.create(this, R.raw.audio);
       // initUI();
        // startTimer();
        //initUI();
      //  mp.start();
    }



    public void pauseSong(View v) {
        mp.pause();
    }

    public void stopSong(View v) {
        mp.stop();
       // mp=MediaPlayer.create(this, R.raw.abcd);
    }


    public void GO(View v) {
        //mp.stop();

        Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
        startActivity(intent);
        SplashActivity.this.finish();
    }

    void stopTimer() {
        try {
            if (sostimer != null) {
                sostimer.cancel();
                sostimer = null;
            }
            if (sostt != null) {
                sostt.cancel();
                sostt = null;
            }
        } catch (final Exception e) {
        }
    }

    void startTimer() {
        try {
            sostimer = new Timer();
            sostt = new TimerTask() {

                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            stopTimer();
                            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                            startActivity(intent);
                            SplashActivity.this.finish();

                        }
                    });

                }
            };
            sostimer.schedule(sostt, delay, period);

        } catch (final Exception e) {
        }

    }

    /*******************************
     * Load Data From Asset Folder
     ***************/
    private void initUI() {
        try {
            InputStream is = getAssets().open("abbrfile.txt");

            // We guarantee that the available method returns the total
            // size of the asset... of course, this does mean that a single
            // asset can't be more than 2 gigs.
            int size = is.available();

            // Read the entire asset into a local byte buffer.
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            // Convert the buffer into a string.
            text = new String(buffer);
            Log.i("Hello ", text);

        } catch (IOException e) {
            // Should never happen!
            throw new RuntimeException(e);
        }


    }







    protected void onResume() {

        super.onResume();
        overridePendingTransition(0, 0);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


}
