package com.example.liupe.fragement_cs1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main10Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
    }

    public void imge(View view) {
        startActivity(new Intent(Main10Activity.this,ViewVidoeActivity.class));
    }

    public void imge1(View view) {
        startActivity(new Intent(Main10Activity.this,ViewVidoe4Activity.class));
    }

    public void imge2(View view) {
        startActivity(new Intent(Main10Activity.this,ViewVidoe1Activity.class));
    }

    public void imge3(View view) {
        startActivity(new Intent(Main10Activity.this,ViewVidoe2Activity.class));
    }

    public void imge4(View view) {
        startActivity(new Intent(Main10Activity.this,ViewVidoe3Activity.class));
    }

    public void imge5(View view) {
        startActivity(new Intent(Main10Activity.this,ViewVidoe5Activity.class));
    }
}
