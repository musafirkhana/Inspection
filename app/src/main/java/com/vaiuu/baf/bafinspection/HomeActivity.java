package com.vaiuu.baf.bafinspection;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class HomeActivity extends Activity  {
    private Context mContext;

    private AlertDialog mGPSDialog;
    private static final int GPS_ENABLE_REQUEST = 0x1001;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        mContext = this;
        initUI();
    }

    private void initUI() {
    }
    public void TRADE1(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("trade",getString(R.string.trade_1));
        startActivity(intent);
    }

    public void TRADE2(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("trade",getString(R.string.trade_2));

        startActivity(intent);
    }

    public void TRADE3(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("trade",getString(R.string.trade_3));
        startActivity(intent);
    }

    public void TRADE4(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("trade",getString(R.string.trade_4));
        startActivity(intent);
    }

    public void TRADE5(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("trade",getString(R.string.trade_5));
        startActivity(intent);
    }

    public void TRADE6(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("trade",getString(R.string.trade_6));
        startActivity(intent);
    }

    public void TRADE7(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("trade",getString(R.string.trade_7));
        startActivity(intent);
    }

    public void TRADE8(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("trade",getString(R.string.trade_8));
        startActivity(intent);
    }

    public void TRADE9(View v) {
        Intent intent = new Intent(this, SystemActivity.class);
        intent.putExtra("trade",getString(R.string.trade_9));
        startActivity(intent);
    }
}
