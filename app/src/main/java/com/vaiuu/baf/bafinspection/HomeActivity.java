package com.vaiuu.baf.bafinspection;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.AssetManager;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;


public class HomeActivity extends Activity implements BaseSliderView.OnSliderClickListener,
        ViewPagerEx.OnPageChangeListener {
    private Context mContext;

    private AlertDialog mGPSDialog;
    private static final int GPS_ENABLE_REQUEST = 0x1001;
    SliderLayout sliderLayout ;

    HashMap<String, String> HashMapForURL ;

    HashMap<String, Integer> HashMapForLocalRes ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        mContext = this;
        initUI();
    }

    private void initUI() {
        sliderLayout = (SliderLayout)findViewById(R.id.slider);


        //Call this method to add images from local drawable folder .
        AddImageUrlFormLocalRes();

        //Call this method to stop automatic sliding.
        //sliderLayout.stopAutoCycle();

        for(String name : HashMapForLocalRes .keySet()){

            TextSliderView textSliderView = new TextSliderView(HomeActivity.this);

            textSliderView
                    .description(name)
                    .image(HashMapForLocalRes .get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());

            textSliderView.getBundle()
                    .putString("extra",name);

            sliderLayout.addSlider(textSliderView);
    }
    }
    public void TRADE1(View v) {
       /* Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("trade",getString(R.string.trade_1));
        startActivity(intent);*/
        commentary();
    }
    private void commentary () {
        openPDFFiles("sample.pdf");
    }

    public void TRADE2(View v) {
        openPDFFiles("armament.pdf");
    }

    public void TRADE3(View v) {
        openPDFFiles("electrical.pdf");
    }

    public void TRADE4(View v) {
        openPDFFiles("lsew.pdf");
    }

    public void TRADE5(View v) {
        openPDFFiles("radio.pdf");
    }

    public void TRADE6(View v) {
        openPDFFiles("engine.pdf");
    }

    public void TRADE7(View v) {
        openPDFFiles("instruement.pdf");
    }

    public void TRADE8(View v) {
        Intent intent = new Intent(this, VideoListActivity.class);
        intent.putExtra("trade",getString(R.string.trade_8));
        startActivity(intent);
    }

    public void TRADE9(View v) {
        Intent intent = new Intent(this, SystemActivity.class);
        intent.putExtra("trade",getString(R.string.trade_9));
        startActivity(intent);
    }

    private void openPDFFiles(String name)

    {
        AssetManager assetManager = getAssets();

        InputStream in = null;
        OutputStream out = null;
        File file = new File(getFilesDir(), name);//here schedule1.pdf is the pdf file name which is keep in assets folder.
        try {
            in = assetManager.open(name);
            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

            copyFile(in, out);
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
        } catch (Exception e) {
            Log.e("tag", e.getMessage());
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse("file://" + getFilesDir() + "/" +
                name), "application/pdf");

        startActivity(intent);
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException

    {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1)

        {
            out.write(buffer, 0, read);
        }
    }

    @Override
    protected void onStop() {

        sliderLayout.stopAutoCycle();

        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

        Toast.makeText(this,slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {

        Log.d("Slider Demo", "Page Changed: " + position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }



    public void AddImageUrlFormLocalRes(){

        HashMapForLocalRes = new HashMap<String, Integer>();
        HashMapForLocalRes.put("মাগুর 1", R.drawable.img0);
        HashMapForLocalRes.put("মাগুর 2", R.drawable.img1);
        HashMapForLocalRes.put("মাগুর 3", R.drawable.img2);
        HashMapForLocalRes.put("মাগুর 4", R.drawable.img3);
        HashMapForLocalRes.put("মাগুর 5", R.drawable.img4);

    }
}
