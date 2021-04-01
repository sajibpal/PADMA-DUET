package com.spal.sajibpal.padma;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by sajib pal on 9/7/2018.
 */

public class CustomAdapter extends BaseAdapter {

    String[] studentname,deptname;
    Context contex1;
    LayoutInflater inflater;

    CustomAdapter(Context contex,String[] cname,String[] cdeptname){

        this.contex1=contex;
        this.studentname=cname;
        this.deptname=cdeptname;

    }
    @Override
    public int getCount() {
        return studentname.length;
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
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){

            inflater=(LayoutInflater) contex1.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.country,parent,false);
        }

        TextView name= (TextView) convertView.findViewById(R.id.txtName);
        TextView dept= (TextView) convertView.findViewById(R.id.department);
        name.setText(studentname[position]);
        dept.setText(deptname[position]);
        return convertView;
    }
}
