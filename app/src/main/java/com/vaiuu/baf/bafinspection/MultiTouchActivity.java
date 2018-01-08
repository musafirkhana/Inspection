package com.vaiuu.baf.bafinspection;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.TextView;


public class MultiTouchActivity extends Activity {
    private String category = "";
    private TextView topbar;
    private TouchImageView touchImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.imageview_activity);
        topbar=(TextView)findViewById(R.id.topbar);

        category = getIntent().getStringExtra("cat");
       /* TouchImageView img = new TouchImageView(this);

        setContentView(img);*/
        touchImageView=(TouchImageView)findViewById(R.id.touch_imageview);
        if(category.equalsIgnoreCase("1")){
            topbar.setText("PHEUMATIC");
            touchImageView.setImageResource(R.drawable.pheumatic);
        }else if(category.equalsIgnoreCase("2")){
            topbar.setText("ELECTRIC");
            touchImageView.setImageResource(R.drawable.electric);
        }else if(category.equalsIgnoreCase("3")){
            topbar.setText("CONTROL");
            touchImageView.setImageResource(R.drawable.control);
        }else if(category.equalsIgnoreCase("4")){
            topbar.setText("STARTING");
            touchImageView.setImageResource(R.drawable.starting);
        }else if(category.equalsIgnoreCase("5")){
            topbar.setText("IGNITION");
            touchImageView.setImageResource(R.drawable.ignition);
        }

        touchImageView.setMaxZoom(6f);
    }

    public void BACK(View v) {
        this.finish();

    }
}
