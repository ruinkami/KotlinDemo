package app.ruinkami.kotlindemo.java;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import app.ruinkami.kotlindemo.R;

/**
 * Created by ruinkami on 2017/6/25.
 */

public class JListAdapter extends BaseAdapter {

    private ArrayList<JStudent> dataList;

    public JListAdapter(ArrayList<JStudent> list) {
        dataList = list;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_java, null);
            holder = new ViewHolder();
            holder.tvName = ((TextView) view.findViewById(R.id.java_student_name));
            holder.tvUniversity = ((TextView) view.findViewById(R.id.java_student_university));
            holder.divider = view.findViewById(R.id.java_student_divider);
            view.setTag(holder);
        }

        holder.tvName.setText(dataList.get(i).getName());
        holder.tvUniversity.setText(dataList.get(i).getUniversity());
        if (i != dataList.size() - 1) {
            holder.divider.setVisibility(View.VISIBLE);
        } else {
            holder.divider.setVisibility(View.GONE);
        }

        return view;
    }

    private class ViewHolder {
        TextView tvName;
        TextView tvUniversity;
        View divider;
    }
}
