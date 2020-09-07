package ddwucom.mobile.test10.practice10_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<MyData> myDataList;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, int layout, ArrayList<MyData> myDataList) {
        this.context = context;
        this.layout = layout;
        this.myDataList = myDataList;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 0;
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
        final int pos = position;
        ViewHolder holder;

        if(convertView == null){
            convertView = layoutInflater.inflate(layout, parent, false);

            holder = new ViewHolder();
            holder.textNo = (TextView)convertView.findViewById(R.id.tvNo);
            holder.textName = (TextView)convertView.findViewById(R.id.tvName);
            holder.textDetail = (TextView)convertView.findViewById(R.id.tvDetail);
            holder.textStatus = (TextView)convertView.findViewById(R.id.tvStatus);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textNo.setText(Integer.valueOf(myDataList.get(pos).get_id()).toString());
        holder.textName.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(context, myDataList.get(pos).getDetail() + " " + myDataList.get(pos).getName() + "의 날씨는 " + myDataList.get(pos).getStatus(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.textName.setText(myDataList.get(pos).getName());
        holder.textDetail.setText(myDataList.get(pos).getDetail());
        holder.textStatus.setText(myDataList.get(pos).getStatus());

        return convertView;
    }

    static class ViewHolder{
        TextView textNo;
        TextView textName;
        TextView textDetail;
        TextView textStatus;
    }
}
