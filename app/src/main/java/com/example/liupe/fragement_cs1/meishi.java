package com.example.liupe.fragement_cs1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class meishi extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meishi);
    }
    public void choudoufu(View view) {

        startActivity(new Intent(meishi.this,Main4Activity.class));
    }

    public void baba(View view) {

        startActivity(new Intent(meishi.this,Main5Activity.class));
    }
    public void xiazi(View view) {

        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://m.baidu.com/sf_bk/item/%E5%8F%A3%E5%91%B3%E8%99%BE/1408250?fr=aladdin&ms=1&rid=11196055439426133180"));
        startActivity(intent);
    }
    public void doupi(View view) {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://m.baike.so.com/doc/5417740-5655888.html"));
        startActivity(intent);
    }

    public void banfen(View view) {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://m.baike.so.com/doc/8845909-9170900.html"));
        startActivity(intent);
    }

    public void cha(View view)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://m.baidu.com/mip/c/www.360doc.cn/mip/611677617.html"));
        startActivity(intent);
    }
}
