package ddwucom.mobile.test10.customadaptertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

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

        myDataList.add(new MyData(1, "홍길동", "012345"));
        myDataList.add(new MyData(2, "전우치", "123456"));
        myDataList.add(new MyData(3, "일지매", "234567"));
        myDataList.add(new MyData(4, "홍길동", "012345"));
        myDataList.add(new MyData(5, "전우치", "123456"));
        myDataList.add(new MyData(6, "일지매", "234567"));
        myDataList.add(new MyData(7, "홍길동", "012345"));
        myDataList.add(new MyData(8, "전우치", "123456"));
        myDataList.add(new MyData(9, "일지매", "234567"));
        myDataList.add(new MyData(10, "홍길동", "012345"));
        myDataList.add(new MyData(11, "전우치", "123456"));
        myDataList.add(new MyData(12, "일지매", "234567"));
        myDataList.add(new MyData(13, "홍길동", "012345"));
        myDataList.add(new MyData(14, "전우치", "123456"));
        myDataList.add(new MyData(15, "일지매", "234567"));
        myDataList.add(new MyData(16, "홍길동", "012345"));
        myDataList.add(new MyData(17, "전우치", "123456"));
        myDataList.add(new MyData(18, "일지매", "234567"));
        myDataList.add(new MyData(19, "홍길동", "012345"));
        myDataList.add(new MyData(20, "전우치", "123456"));

        myAdapter = new MyAdapter(this, R.layout.custom_adapter_view, myDataList);

        listView = (ListView)findViewById(R.id.customListView);

        listView.setAdapter(myAdapter);
    }
}
