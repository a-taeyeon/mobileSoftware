package ddwucom.mobile.test08.practice8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CatManager catManager;
    ArrayAdapter<String> adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        catManager = new CatManager();

        ArrayList<String> catList = catManager.getCatList();

        adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, catList
        );

        listView = (ListView)findViewById(R.id.listView);

        listView.setAdapter(adapter);
    }
}
