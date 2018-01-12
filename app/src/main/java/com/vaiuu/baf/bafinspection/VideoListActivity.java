package com.vaiuu.baf.bafinspection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;


public class VideoListActivity extends Activity {
private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_videolist);
        mContext=this;
    }
    public void BACK(View v) {
        this.finish();

    }
    public void VID1(View v) {
        Intent intent = new Intent(this, VideoActivity.class);
        intent.putExtra("vid","HGKXdYCksAQ");
        startActivity(intent);

    }
    public void VID2(View v) {
        Intent intent = new Intent(this, VideoActivity.class);
        intent.putExtra("vid","0SfNrzo0wPg");
        startActivity(intent);

    }
    public void VID3(View v) {
        Intent intent = new Intent(this, VideoActivity.class);
        intent.putExtra("vid","7Ko7jAsrkD8");
        startActivity(intent);

    }

}
