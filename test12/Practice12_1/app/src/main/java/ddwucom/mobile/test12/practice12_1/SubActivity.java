package ddwucom.mobile.test12.practice12_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();

        String str = intent.getStringExtra("str");
        TextView textView = findViewById(R.id.etSub);
        textView.setText(str);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnSub:
                finish();
                break;
        }
    }
}
