package ddwucom.mobile.test05.practice5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //SoundPool soundPool;
    //int sound;
    AudioManager audioManager;

    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        //sound = audioManager.load(this, R.raw.dingdong, 1);
       audioManager = (AudioManager)getSystemService(AUDIO_SERVICE);

       vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void onClick(View v){

        switch(v.getId()){
            case R.id.btnToast :
                Toast.makeText(this, "안태연", Toast.LENGTH_LONG).show();
                break;

            case R.id.btnSound :
                //soundPool.play(sound, 1, 1, 0, 0, 1);
                audioManager.playSoundEffect(AudioManager.FX_KEYPRESS_STANDARD);
                break;

            case R.id.btnVibration :
                //vibrator.vibrate(1000); //1000ms = 1s간 진동
                vibrator.vibrate(new long[] {100, 50, 200, 50}, 0);
                break;

            case R.id.btnVibrationCancel :
                vibrator.cancel();
                break;
        }

    }
}