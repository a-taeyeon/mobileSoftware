package ddwucom.mobile.test05.etcapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SoundPool soundPool; //soundPool은 효과음을 출력하기 위해서 만들어짐
    int sound;

    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        sound = soundPool.load(this, R.raw.door, 1);    //소리를 로딩하는 작업

        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void onClick(View v){

        switch(v.getId()) {
            case R.id.button:
                /*위의 20~21라인이 이 자리에 들어간다면 버튼을 누르는 순간 soundPool을 준비하고
                soundPool에서 소리를 load하는 작업을 하면 시간이 걸려서 소리가 안날 가능성이 높음*/
               soundPool.play(sound, 1, 1, 0, 0, 1);
                break;

            case R.id.button2 :
                vibrator.vibrate(500);
                /*vibrator.vibrate(500); 하면 에러메세지가 나오는데*/
                break;
        }

    }
}
