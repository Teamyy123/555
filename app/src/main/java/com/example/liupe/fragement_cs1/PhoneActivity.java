package com.example.liupe.fragement_cs1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class PhoneActivity extends AppCompatActivity {
    private List<Phone> dataList;
    private PhoneDao dao;
    private ListView phoneListView;
    private EditText ed_phone_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        phoneListView=(ListView) this.findViewById(R.id.phone_listview);
        ed_phone_search=(EditText) this.findViewById(R.id.ed_phone_search);
        dao=new PhoneDao(this,1);

        setPhoneListData(null);
        phoneListView.setOnItemClickListener(listener);

        ed_phone_search.addTextChangedListener(searchListener);
    }
    private TextWatcher searchListener=new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) { }

        @Override
        public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) { }

        @Override
        public void afterTextChanged(Editable txt) {
           // Toast.makeText(PhoneActivity.this,txt.toString(),Toast.LENGTH_LONG).show();
            PhoneActivity.this.setPhoneListData(txt.toString());
        }
    };
    private void setPhoneListData(String name){
        dataList=dao.select(name);
        phoneListView.setAdapter(new PhoneAdapter(this, dataList));
    }

    private AdapterView.OnItemClickListener listener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int index, long id) {
            /*RelativeLayout r1=(RelativeLayout) view;
            TextView txt= (TextView) r1.getChildAt(1);*/

            Phone phone=dataList.get(index);
            String phoneNumber=phone.getNumber();

            Intent intent=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+phoneNumber));
            PhoneActivity.this.startActivity(intent);
        }
    };

    class PhoneAdapter extends BaseAdapter{

        private List<Phone> datas;
        private Context context;
        private LayoutInflater layoutInflater;

        public PhoneAdapter(Context context, List<Phone> dataList){
            this.context=context;
            this.datas=dataList;
            layoutInflater=LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int index, View view, ViewGroup arg2) {
            if (null==view){
                view=layoutInflater.inflate(R.layout.phone_item_layout, null);
            }
            TextView phone_name=view.findViewById(R.id.phone_name);
            TextView phone_number=(TextView) view.findViewById(R.id.phone_number);

            Phone phone=datas.get(index);
            phone_name.setText(phone.getName());
            phone_number.setText(phone.getNumber());
            return view;
        }
    }
}
