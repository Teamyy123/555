package com.example.liupe.fragement_cs1;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class ViewVidoe2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null);
        actionBar.hide();
        setContentView(R.layout.activity_view_vidoe2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);// 横

        VideoView videoView1=findViewById(R.id.spacer_a14);
        videoView1.setVideoURI(Uri.parse( "android.resource://" + getPackageName() + "/" +R.raw.congyoubaba ));
        videoView1.requestFocus();
        videoView1.setMediaController(new MediaController(this));
        videoView1.start();
    }
}
