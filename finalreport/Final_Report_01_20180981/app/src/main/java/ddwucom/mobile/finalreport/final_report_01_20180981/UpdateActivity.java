package ddwucom.mobile.finalreport.final_report_01_20180981;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class UpdateActivity extends AppCompatActivity {

    Movie movie;

    ImageView etImage;
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
        setContentView(R.layout.activity_update);
        movie = (Movie) getIntent().getSerializableExtra("movie");

        etImage = findViewById(R.id.et_image);
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

        switch (movie.getNation()){
            case "korea":
                etImage.setImageResource(R.mipmap.korea);
                break;
            case "japan":
                etImage.setImageResource(R.mipmap.japan);
                break;
            case "taiwan":
                etImage.setImageResource(R.mipmap.taiwan);
                break;
            case "uk":
                etImage.setImageResource(R.mipmap.uk);
                break;
            case "usa":
                etImage.setImageResource(R.mipmap.usa);
                break;

        }
        etTitle.setText(movie.getTitle());
        etNation.setText(movie.getNation());
        etDirector.setText(movie.getDirector());
//        etReleaseDate.setText(movie.getReleaseDate());
        etGenre.setText(movie.getGenre());

        movieDBManager = new MovieDBManager(this);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_upate:

                movie.setTitle(etTitle.getText().toString());
                movie.setNation(etNation.getText().toString());
                movie.setDirector(etDirector.getText().toString());
                movie.setReleaseDate(releaseDate);
                movie.setGenre(etGenre.getText().toString());

                if(etTitle.getText().toString().equals("") || etNation.getText().toString().equals("")){
                    Toast.makeText(this, "제목과 국가는 필수항목입니다.\n필수항목을 입력하세요.", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (movieDBManager.modifyMovie(movie)) {

                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("movie", movie);
                        setResult(RESULT_OK, resultIntent);
                    } else {
                        setResult(RESULT_CANCELED);
                    }
                    finish();
                }
                break;

            case R.id.btn_cancel:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}
