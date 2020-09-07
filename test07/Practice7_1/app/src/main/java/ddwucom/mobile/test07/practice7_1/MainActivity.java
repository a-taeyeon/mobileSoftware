package ddwucom.mobile.test07.practice7_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.cfood01:
                Toast.makeText(this,"짜장면 좋아요", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cfood02:
                Toast.makeText(this,"짬뽕은 딱히", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    public void onMenuKimchi (MenuItem item){
        Toast.makeText(this,"돼지고기 김치찌개는 좋아요", Toast.LENGTH_SHORT).show();
    }
    public void onMenuTofu (MenuItem item){
        Toast.makeText(this,"순두부찌개는 그냥그럼", Toast.LENGTH_SHORT).show();
    }
}
