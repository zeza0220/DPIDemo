package com.txznet.dpidemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去除状态栏
        //SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        WindowManager windowManager = getWindow().getWindowManager();


        TextView tvRealSize=(TextView) findViewById(R.id.tv_real_size);
        Point point_fact = new Point();
        windowManager.getDefaultDisplay().getRealSize(point_fact);
        tvRealSize.setText("width:"+point_fact.x+"\n" +
                "height:"+point_fact.y);


        TextView tvSize=(TextView) findViewById(R.id.tv_size);
        Point point_use = new Point();
        windowManager.getDefaultDisplay().getSize(point_use);
        tvSize.setText("width:"+point_use.x+"\n" +
                "height:"+point_use.y);

        TextView tvRect=(TextView) findViewById(R.id.tv_rect);
        Rect rect=new Rect();
        windowManager.getDefaultDisplay().getRectSize(rect);
        tvRect.setText("top:"+rect.top+"\n" +
                "bottom:"+rect.bottom+"\n"+
                "left:"+rect.left+"\n"+
                "right:"+rect.right);


        TextView tvMetrics=(TextView) findViewById(R.id.tv_metrics);
        DisplayMetrics metrics=new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metrics);
        tvMetrics.setText("width:"+metrics.widthPixels+"\n" +
                "height:"+metrics.heightPixels);

        TextView tvRealMetrics=(TextView) findViewById(R.id.tv_real_metrics);
        DisplayMetrics metrics1=new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(metrics1);
        tvRealMetrics.setText("width:"+metrics1.widthPixels+"\n" +
                "height:"+metrics1.heightPixels);

        Button btnUi1=(Button) findViewById(R.id.btn_ui_1);
        btnUi1.setOnClickListener(view -> {
            Intent intent=new Intent(this,UiTest1Activity.class);
            startActivity(intent);
        });
    }
}