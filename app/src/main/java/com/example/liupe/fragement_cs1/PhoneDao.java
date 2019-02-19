package com.example.liupe.fragement_cs1;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class PhoneDao extends SQLiteOpenHelper {
    private final String[] phonename = { "长沙火车站订票", "长沙火车站咨询", "国家旅游投诉",
            "长沙高铁站客服", "长沙火车南站咨询", "长沙火车站投诉", "长沙火车南站订票", "长沙汽车东站订票",
            "长沙汽车西站", "长沙汽车西站客服咨询", "长沙南站咨询", "长沙黄花机场咨询", "南航服务咨询在线", "机场失物招领服务在线",
            "长沙黄花机场投诉服务在线", "湖南省森林植物园", "杜甫江阁 ", "马王堆汉墓 ", "湖南国际会展中心 ",
            "湖南省展览馆 ", "湖南省博物馆 ", "烈士公园 ", "橘子洲头 ", "世界之窗旅游区 " };
    private final String[] phonenumber = { "0731-95105105", "0731-12306",
            "01065275315", "0731-82637122", "0731-280505", "0731-82637182",
            "95105105", "0731-84611431", "0731-88708700", "400-6860200", "0731-96228",
            "0731-96777", "0731-84799333", "0731-84799345", "95539", "0731-85656747",
            "0731-85821786", "0731-84514630", "0731-84838000", "：0731-82225259", "0731-84514630",
            "0731-83621777", "0731-88614640", "0731-84256888" };


    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *  @param context to use for locating paths to the the database
     * @param version number of the database (starting at 1); if the database is older,
     *                {@link #onUpgrade} will be used to upgrade the database; if the database is
     *                newer, {@link #onDowngrade} will be used to downgrade the database
     */
    public PhoneDao(Context context, int version) {
        super(context,"phonedb",null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tab_phone(_id integer primary key autoincrement,name text,number text)");

        for (int i=0;i<phonename.length;i++){
            db.execSQL("insert into tab_phone(name,number) values(?,?)",new Object[] {phonename[i],phonenumber[i]});
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {

    }
    public List<Phone> select (String name){
        List<Phone> list=new ArrayList<Phone>();
        String sql="select * from tab_phone where 1=1";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=null;
        if (null!=name&&!"".equals(name)){
            sql+=" and name like ?";
            cursor=db.rawQuery(sql, new String[]{"%"+name+"%"});
        }else{
            cursor=db.rawQuery(sql, null);
        }
        while(cursor.moveToNext()){
            Phone p=new Phone();
            p.setId(cursor.getInt(cursor.getColumnIndex("_id")));
            p.setName(cursor.getString(cursor.getColumnIndex("name")));
            p.setNumber(cursor.getString(cursor.getColumnIndex("number")));
            list.add(p);
        }
        cursor.close();
        db.close();
        return list;
    }
}