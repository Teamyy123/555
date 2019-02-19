package com.example.liupe.fragement_cs1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class meijin extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meijin1);
    }

    public void zhiwu(View view) {
        startActivity(new Intent(meijin.this,Main2Activity.class));
    }
    public void tt(View view) {

        startActivity(new Intent(meijin.this,Main3Activity.class));
    }

    public void adim(){

    }

    public void yulushag(View view) {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://m.baike.so.com/doc/4753705-4969111.html"));
        startActivity(intent);
    }


    public void shijie(View view) {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://m.baike.so.com/doc/5614316-5826926.html"));
        startActivity(intent);
    }

    public void zi(View view) {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://m.meet99.com/jingdian-hunanzhiwuyuan.html"));
        startActivity(intent);
    }

    public void yuelushan(View view) {
        startActivity(new Intent(meijin.this,MainActivity.class));
    }

    public void juzi(View view) {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://m.baike.so.com/doc/2063492-2183090.html"));
        startActivity(intent);
    }

    public void songya(View view) {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://m.baike.so.com/doc/2536258-2679270.html"));
        startActivity(intent);
    }

    public void meixi(View view) {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://m.baike.so.com/doc/5392604-5629444.html"));
        startActivity(intent);
    }
}
