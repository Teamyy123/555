package com.example.liupe.fragement_cs1;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class ZU_Activity extends AppCompatActivity {
    private Spinner spinner;
    private EditText editText;
    private String name;
    private DrawerLayout dra1;

     ActionBarDrawerToggle actionBarDrawerToggle;
Toolbar toolbar1;
  //  pr1ivate Toolbar toolbar1;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhujiemian);
       spinner=findViewById(R.id.spread);


        NavigationView menuItemView2=(NavigationView) findViewById(R.id.nacigation123);

        menuItemView2.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {

                if (item.getItemId()==R.id.app_meishi)
                {
                    Intent intent=new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://m.weathercn.com/en/cn/changsha/105567/extended-weather-forecast/105567?unit=c&lang=en-us&partner=1000001045_hfaw"));
                    startActivity(intent);
                    return true;
                }
                if (item.getItemId()==R.id.app_meishi1)
                {
                    startActivity(new Intent(ZU_Activity.this,meijin.class));
                    return true;
                }
                if (item.getItemId()==R.id.app_meishi2)
                {
                    startActivity(new Intent(ZU_Activity.this,meishi.class));
                    return true;
                }
                if (item.getItemId()==R.id.app_meishi3)
                {
                    startActivity(new Intent(ZU_Activity.this,PhoneActivity.class));
                    return true;
                }
                if (item.getItemId()==R.id.app_meishi6)
                {
                    startActivity(new Intent(ZU_Activity.this,Main10Activity.class));
                    return true;
                }

              return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId())
        {
            case R.id.men1:
                Intent intent=new Intent(ZU_Activity.this,Logn.class);
                startActivity(intent);
                break;
            case R.id.men2:
            Intent intent1=new Intent(ZU_Activity.this,MainActivity.class);
            startActivity(intent1);
            break;
            case R.id.men3:
            Intent intent2=new Intent(ZU_Activity.this,Main2Activity.class);
            startActivity(intent2);
            break;
            case R.id.men4:
                Intent intent3=new Intent(ZU_Activity.this,Main3Activity.class);
                startActivity(intent3);
                break;
            case R.id.men5:
                Intent intent4=new Intent(ZU_Activity.this,Main4Activity.class);
                startActivity(intent4);
                break;
            case R.id.men6:
                Intent intent5=new Intent(ZU_Activity.this,Main5Activity.class);
                startActivity(intent5);
                break;
            case R.id.men7:
                Intent intent6=new Intent(ZU_Activity.this,Main6Activity.class);
                startActivity(intent6);
                break;
            case R.id.men8:
                Intent intent7=new Intent(ZU_Activity.this,PhoneActivity.class);
                startActivity(intent7);
                break;
            default:break;
        }
        return true;
    }

    public void meijin(View view) {

        startActivity(new Intent(ZU_Activity.this,meijin.class));
    }

    public void meishi(View view) {
        startActivity(new Intent(ZU_Activity.this,meishi.class));
    }

    public void dianhua(View view) {
        startActivity(new Intent(ZU_Activity.this,PhoneActivity.class));
    }

    public void tianqi(View view) {
            startActivity(new Intent(ZU_Activity.this,Main10Activity.class));
    }
}
