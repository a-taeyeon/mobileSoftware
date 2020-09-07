package ddwucom.mobile.test05.practice5_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private MyView myView; //아래에서 매번 findViewById로 알아내지 않고 myView객체를 만들어서 사용.
    Random random;
    int x, y, r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = findViewById(R.id.myView); //이 myView가 화면에 직접 만든 custom MyView임.

        random = new Random();


    }

    public void onClick(View v){

        switch (v.getId()){
            case R.id.button :

                x = random.nextInt(myView.getWidth());
                y = random.nextInt(myView.getHeight());
                r = random.nextInt(random.nextInt(3)+1) * 100;

                myView.setCircleX(x);
                myView.setCircleY(y);
                myView.setCircleR(r);
                myView.invalidate();    //다시 그려줘야하니까 invalidate로 화면을 무효화시키고 다시 그려지게 만들면 됨.

                break;
        }
    }
}
