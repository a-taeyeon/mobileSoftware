package ddwucom.mobile.test05.customview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){

        MyCustomView myView = findViewById(R.id.myView);

        myView.setCircleY(myView.getCircleY() + 100);

//        myView.onDraw(); //이렇게 호출하면 안됨. on-메소드는 시스템이 호출하는 것이기 때문에.
        myView.invalidate(); //화면을 다시 그릴땐 이렇게 해야함.

        //사실 원이 움직이는 것이 아니 y값이 + 100 된 상태로 다시 그려지는거임.
    }

    class MyView extends View {

        public MyView(Context context) { //필수
            super(context);
        }

        public MyView(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
        }

        public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawColor(Color.LTGRAY);

            Paint pnt = new Paint();
            pnt.setColor(Color.BLUE);

            canvas.drawCircle(100, 100, 80, pnt);

        }
    }
}