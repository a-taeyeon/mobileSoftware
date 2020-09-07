package ddwu.com.mobile.exam.mycircletest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MyCircle myCircle;

    final static int MENU_RED = 100;
    final static int MENU_GREEN = 200;
    final static int MENU_BLUE = 300;

    static int select = R.id.g_red;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Custom View 객체*/
        myCircle = findViewById(R.id.myCircle);

        registerForContextMenu(myCircle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.memu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.bigger:
                myCircle.setR(myCircle.getR()+5);
                break;
            case R.id.smaller:
                myCircle.setR(myCircle.getR()-5);
                break;
        }
        myCircle.invalidate();
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        switch(v.getId()) {
            case R.id.myCircle:
                menu.setHeaderTitle("Change Color");

                //contextMenu
                /* R.id.g_red대신 MENU_RED써주면 case문에서 MENU_RED라고 할 때만 돌아가고
                   R.id.g_red라고 할 때는 안돌아감. 무슨차이..?*/
//                menu.add(0, R.id.g_red, 0, "RED");
//                menu.add(0, R.id.g_green, 0, "GREEN");
//                menu.add(0, R.id.g_blue, 0, "BLUE");

                //radio버튼
                getMenuInflater().inflate(R.menu.menu_radio, menu);
                menu.findItem(select).setChecked(true);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.g_red:
                item.setChecked(true);
                select = R.id.g_red;
                myCircle.setPaintColor(Color.RED);
                break;
            case R.id.g_green:
                item.setChecked(true);
                select = R.id.g_green;
                myCircle.setPaintColor(Color.GREEN);
                break;
            case R.id.g_blue:
                item.setChecked(true);
                select = R.id.g_blue;
                myCircle.setPaintColor(Color.BLUE);
                break;
        }
        myCircle.invalidate();
        return super.onContextItemSelected(item);
    }
}
