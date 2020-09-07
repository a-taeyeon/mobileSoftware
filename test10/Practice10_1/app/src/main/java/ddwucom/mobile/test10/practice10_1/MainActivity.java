package ddwucom.mobile.test10.practice10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<MyData> myDataList;
    private MyAdapter myAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.customListView);

        myDataList = new ArrayList<>();

        myDataList.add(new MyData(1, "하월곡동", "서울시 성북구", "좋음"));

        myAdapter = new MyAdapter(this, R.layout.custom_adapter_view, myDataList);

        listView = (ListView)findViewById(R.id.customListView);

        listView.setAdapter(myAdapter);
    }

}
