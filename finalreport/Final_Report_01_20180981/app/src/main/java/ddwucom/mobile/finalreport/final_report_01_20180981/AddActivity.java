package ddwucom.mobile.finalreport.final_report_01_20180981;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AddActivity extends AppCompatActivity {

    Movie movie;

    EditText etTitle;
    EditText etNation;
    EditText etDirector;
//    EditText etReleaseDate;
    DatePicker datePicker;
    Calendar calendar;
    String releaseDate = "";
    EditText etGenre;

    MovieDBManager movieDBManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etTitle = findViewById(R.id.et_title);
        etNation = findViewById(R.id.et_nation);
        etDirector = findViewById(R.id.et_director);
        calendar = Calendar.getInstance();
        datePicker = (DatePicker)findViewById(R.id.datePicker);
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
                new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        releaseDate = year + "." + (month+1) + "." + dayOfMonth;
                    }
                });
        etGenre = findViewById(R.id.et_genre);

        movieDBManager = new MovieDBManager(this);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.btn_upate:
                if(etTitle.getText().toString().equals("") || etNation.getText().toString().equals("")){
                    Toast.makeText(this, "제목과 국가는 필수항목입니다.\n필수항목을 입력하세요.", Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean result = movieDBManager.addNewMovie(
                            new Movie(etTitle.getText().toString(), etNation.getText().toString(), etDirector.getText().toString(), releaseDate, etGenre.getText().toString()));


                    if (result) {    // 정상수행에 따른 처리
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("movie", etTitle.getText().toString());
                        setResult(RESULT_OK, resultIntent);
                        finish();
                    } else {        // 이상에 따른 처리
                        Toast.makeText(this, "새로운 영화 추가 실패!", Toast.LENGTH_SHORT).show();
                    }
                }
                break;

            case R.id.btn_cancel:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}
