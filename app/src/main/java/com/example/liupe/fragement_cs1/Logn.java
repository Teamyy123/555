package com.example.liupe.fragement_cs1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Logn extends AppCompatActivity {

    private EditText et_qqnumber;
    private EditText et_passwd;
    private CheckBox ZD;
    private CheckBox cb_remember;
    Boolean zidong =false;
    Boolean chek = false;
    public SharedPreferences sp;
    Boolean che1;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logn);
///**
// * 去掉标题
// */
//
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null)
//        {
//            actionBar.hide();
//        }

        sp = this.getSharedPreferences("config", this.MODE_PRIVATE);






        /**
         *
         * 每次点击返回登录界面，都会把自动登录设置成false
         */
        zidong = false;
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("zidong12", zidong);
        editor.apply();

        /**
         * 取出存进去的密码，判断密码选中
         */pdmima();

    }

    public  void pdmima()
    {


        //zidong = sp.getBoolean("zidong12", false);//取出
        chek = sp.getBoolean("chek12", false);

        et_qqnumber = (EditText) findViewById(R.id.et_qqnumber);
        et_passwd = (EditText) findViewById(R.id.et_passwd);
        cb_remember = (CheckBox) findViewById(R.id.cb_remember);
        ZD = (CheckBox) findViewById(R.id.mima_a1);


        if (chek)
        {   //是否记住密码

            String qq = sp.getString("qq12", "");
            String password = sp.getString("password12", "");
            et_qqnumber.setText(qq);
            et_passwd.setText(password);

        } else
        {

            String qq = sp.getString("qq12", "");
            et_qqnumber.setText(qq);
        }

    }

    /**
     * 用户按下返回键时先提示，然后确认是否退出
     */
    private long exitTime = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN)
        {
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();


                exitTime = System.currentTimeMillis();

            } else
            {


                Intent home = new Intent(Intent.ACTION_MAIN);
                home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                home.addCategory(Intent.CATEGORY_HOME);
                startActivity(home);

            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    /**
     * 点击登录
     */
    public void login(View view)
    {

        String qq = et_qqnumber.getText().toString().trim();
        String password = et_passwd.getText().toString().trim();

        if (TextUtils.isEmpty(qq) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "用户名和密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        } else
        {

            //判断密码

            if ("10000".equals(qq) && "123456".equals(password))
            {
                Boolean zhengque= true;
                SharedPreferences.Editor editor8 = sp.edit();//编辑
                editor8.putBoolean("zhengque",zhengque);
                editor8.apply();


                /**
                 * 密码被选中就存一个turn 否则就存一个false
                 */
                if (cb_remember.isChecked())
                {
                    // 被选中状态，需要记录用户名和密码  将数据保存到sp文件中
                    chek = true;
                    SharedPreferences.Editor editor1 = sp.edit();//编辑
                    editor1.putString("qq12", qq);
                    editor1.putBoolean("chek12", chek);
                    editor1.putString("password12", password);
                    editor1.apply();// 提交数据，类似关闭流，事务
                }else {

                    che1 = false;
                    SharedPreferences.Editor editor2 = sp.edit();//编辑
                    editor2.putBoolean("chek12", che1);
                    editor2.apply();

                }


                if (ZD.isChecked())
                {
                    zidong = true;
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("zidong12", zidong);
                    editor.apply();
                }

                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                finish();
            }
            else
            {
                Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
            }
        }


    }


}
