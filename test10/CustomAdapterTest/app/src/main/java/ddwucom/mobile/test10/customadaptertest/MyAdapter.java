package ddwucom.mobile.test10.customadaptertest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<MyData> myDataList;
    private LayoutInflater layoutInflater;

    static final String TAG = "MyAdapter";
    int count;

    public MyAdapter(Context context, int layout, ArrayList<MyData> myDataArrayList) {
        this.context = context;
        this.layout = layout;
        this.myDataList = myDataArrayList;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        count = 0;
    }

    @Override
    public int getCount() {
        return myDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return myDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myDataList.get(position).get_id();
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup viewGroup) {
        final int position = pos;
        ViewHolder holder;

        Log.d(TAG, "getView()!!");

        if(convertView == null){
            convertView = layoutInflater.inflate(layout, viewGroup, false);

            holder = new ViewHolder();
            holder.textNo = (TextView)convertView.findViewById(R.id.tvNo);
            holder.textName = (TextView)convertView.findViewById(R.id.tvName);
            holder.textPhone = (TextView)convertView.findViewById(R.id.tvPhone);
            holder.btnCheck = (Button)convertView.findViewById(R.id.button);
            convertView.setTag(holder);

            Log.d(TAG, "count: " + ++count);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.textNo = convertView.findViewById(R.id.tvNo);
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvPhone = convertView.findViewById(R.id.tvPhone);
        Button btnCheck = convertView.findViewById(R.id.button);
        btnCheck.setFocusable(false);

        holder.textNo.setText(Integer.valueOf(myDataList.get(position).get_id()).toString());
        holder.textName.setText(myDataList.get(position).getName());
        holder.textPhone.setText(myDataList.get(position).getPhone());
        holder.btnCheck.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(context, myDataList.get(position).getPhone() + " 선택", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }


    static  class ViewHolder{
        TextView textNo;
        TextView textName;
        TextView textPhone;
        Button btnCheck;
    }
}
