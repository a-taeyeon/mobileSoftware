package ddwucom.mobile.test05.practice5_2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {

    int circleX;
    int circleY;
    int circleR;

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        /*위의 생성자 중 어떤 생성자에 들어가게 될지 모르기때문에
        생성자마다 초기값 100이라고 해주는 것보다 init메소드를 만들어서 해주는게 좋음.*/
        circleX = 100;
        circleY = 100;
        circleR = 80;
    }

    //외부클래스에서도 circleX, circleY 이용해야되니까 getter, setter 만들어줌
    public int getCircleX() {
        return circleX;
    }

    public void setCircleX(int circleX) {
        this.circleX = circleX;
    }

    public int getCircleY() {
        return circleY;
    }

    public void setCircleY(int circleY) {
        this.circleY = circleY;
    }

    public int getCircleR() {
        return circleR;
    }

    public void setCircleR(int circleR) {
        this.circleR = circleR;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        canvas.drawColor(Color.YELLOW);

        Paint pnt = new Paint();
        pnt.setColor(Color.CYAN);

        canvas.drawCircle(circleX, circleY, circleR, pnt);
    }
}
