package ddwucom.mobile.test12.activitytest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final static int REQ_CODE = 100;
    final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.button:
                //SubActivity1
//                Intent intent = new Intent(MainActivity.this, SubActivity1.class);
//
//                String id = "cooling";
//
//                intent.putExtra("id", id);
//
//                ArrayList<String> foods = new ArrayList<String>();
//                foods.add("사과");
//                foods.add("배");
//                foods.add("오렌지");
//
//                intent.putExtra("foods", foods);
//
//                startActivity(intent);

                //SubActivity2
//                Intent intent2 = new Intent(MainActivity.this, SubActivity2.class);
//
//                startActivityForResult(intent2, REQ_CODE);

                //묵시적으로 전화기능 호출
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:012-1234-5678"));
                startActivity(intent);
                break;
        }
    }

    //SubActivity2를 위한 메소드
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (REQ_CODE){
            case REQ_CODE:
                if(resultCode == RESULT_OK){
                    String result = data.getStringExtra("result_data");
                    Log.d(TAG, "Result : " + result);
                }   else{
                    Log.d(TAG, "canceled!");
                }
                break;
        }
    }
}
