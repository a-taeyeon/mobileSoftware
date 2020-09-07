package ddwucom.mobile.test07.menutest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";

    final static int MENU_FIRST = 100;
    final static int MENU_SECOND = 200;

    PopupMenu popup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);

        popup = new PopupMenu(this, textView);

        popup.getMenuInflater().inflate(R.menu.menu_main, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(MainActivity.this, "Hi", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        textView.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popup.show();
                return true;
            }
        });

//        registerForContextMenu(textView);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case MENU_FIRST:
                Log.i(TAG, "context 1");
                break;
            case MENU_SECOND:
                Log.i(TAG, "context 2");
                break;
            case R.id.third:
                Log.i(TAG, "context 3");
                break;
            case R.id.fourth:
                Log.i(TAG, "context 4");
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        switch (v.getId()){
            case R.id.textView:
                menu.setHeaderTitle("Context Menu"); //얘가 무슨 메뉴인지 알려주려면 이렇게 헤드에 정보를 기록해도 좋음.

                //코드로 직접 작성
                menu.add(0, MENU_FIRST, 0, "FIRST");
                menu.add(0, MENU_SECOND, 0, "SECOND");

                //xml로 설계
                getMenuInflater().inflate(R.menu.menu_context, menu);
                break;
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.group_menu, menu);
        return true;
    }
/*
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
*/
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

//        switch (item.getItemId()){
//            case R.id.item01:
//                Log.i(TAG, "item01 is clicked!");
//                break;
//            case R.id.subItem01:
//                Log.i(TAG, "subItem01 is clicked!");
//                break;
//            case R.id.subItem02:
//                Log.i(TAG, "subItem02 is clicked!");
//                break;
//        }

        switch (item.getItemId()){
            //클릭하는 순간 체크되도록.
           case R.id.gitem01:
                if(item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                break;
            case R.id.gitem02:
                if(item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                break;

            //체크박스는 체크 상태를 확인해줘야하지만 Radio버튼은 그럴 필요 없음
            case R.id.gitem03:
                item.setChecked(true);
                break;
            case R.id.gitem04:
                item.setChecked(true);
                break;
        }


        return true;
    }

    //MenuItem을 눌렀을 때 onOptionsItemSelected도 호출되고 onMenuItemClick도 호출될 수 있음.
    //그러면 어떤것이 우선순위로 동작하느냐
    //MenuItem 클릭하는 것을 onOptionsItemSelected에 구현할 수도 있고
    // xml에서 메소드를 정한다음에 그 메소드를 별도로 만들어서 클릭기능을 수행할 수도 있는데
    //만약에 xml에서 지정한 내용이 있을 경우엔 onMenuItemClick이 우선임.
    //그러고 나서 얘가 우선이 없으면 onOptionsItemSelected에서 해당 item을 처리할 수 있는게 있는지 확인함.

    //이 방법이 있는 이유는 액션바때문에 있는건데 액션바의 아이콘이 복잡한 기능을 수행한다고 할 때
    //switch안에 여러개의 기능을 수행하기 위해서 코드를 작성하면 문제가 생길 수도 있기 때문에
    //이렇게 별도의 메소드로 만드는게 좋을 수도 있음.
    public void onMenuItemClick (MenuItem item){
        Log.i(TAG, "item01 is clicked!!!!!");
    }

}
