package ddwucom.mobile.finalreport.final_report_01_20180981;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Movie> myMovieList;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, int layout, ArrayList<Movie> myMovieList) {
        this.context = context;
        this.layout = layout;
        this.myMovieList = myMovieList;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myMovieList.size();
    }

    @Override
    public Object getItem(int pos) {
        return myMovieList.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return myMovieList.get(pos).get_id();
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup viewGroup) {
        final int position = pos;

        if(convertView == null){
            convertView = layoutInflater.inflate(layout, viewGroup, false);
        }

        //화면요소 준비
        ImageView imgNation = convertView.findViewById(R.id.imgNation);
        TextView tvTitle = convertView.findViewById(R.id.tvTitle);
        TextView tvDirector = convertView.findViewById(R.id.tvDirector);
        TextView tvReleaseDate = convertView.findViewById(R.id.tvReleaseDate);

        //화면+데이터 결합
        if("korea".equals(myMovieList.get(position).getNation()))
            imgNation.setImageResource(R.mipmap.korea);
        else if("japan".equals(myMovieList.get(position).getNation()))
            imgNation.setImageResource(R.mipmap.japan);
        else if("taiwan".equals(myMovieList.get(position).getNation()))
            imgNation.setImageResource(R.mipmap.taiwan);
        else if("uk".equals(myMovieList.get(position).getNation()))
            imgNation.setImageResource(R.mipmap.uk);
        else if("usa".equals(myMovieList.get(position).getNation()))
            imgNation.setImageResource(R.mipmap.usa);

        tvTitle.setText(myMovieList.get(position).getTitle());
        tvDirector.setText(myMovieList.get(position).getDirector());
        tvReleaseDate.setText(myMovieList.get(position).getReleaseDate());

        return convertView;
    }
}
