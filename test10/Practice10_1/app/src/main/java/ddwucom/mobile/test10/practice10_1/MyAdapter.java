package ddwucom.mobile.test10.practice10_1;

import android.content.Context;
import android.text.Layout;
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

    public MyAdapter(Context context, int layout, ArrayList<MyData> myDataList) {
        this.context = context;
        this.layout = layout;
        this.myDataList = myDataList;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;

        if(convertView == null){
            convertView = layoutInflater.inflate(layout, parent, false);
        }

        TextView textNo = convertView.findViewById(R.id.tvNo);
        TextView textName = convertView.findViewById(R.id.tvName);
        TextView textDetail = convertView.findViewById(R.id.tvDetail);
        TextView textStatus = convertView.findViewById(R.id.tvStatus);

        textNo.setText(Integer.valueOf(myDataList.get(pos).get_id()).toString());
        textName.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(context, myDataList.get(pos).getDetail() + " " + myDataList.get(pos).getName() + "의 날씨는 "
                        + myDataList.get(pos).getStatus(), Toast.LENGTH_SHORT).show();
            }
        });
        textName.setText(myDataList.get(pos).getName());
        textDetail.setText(myDataList.get(pos).getDetail());
        textStatus.setText(myDataList.get(pos).getStatus());

        return convertView;
    }

}
