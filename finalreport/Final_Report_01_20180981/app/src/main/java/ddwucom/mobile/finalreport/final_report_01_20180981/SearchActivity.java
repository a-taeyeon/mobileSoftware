package ddwucom.mobile.finalreport.final_report_01_20180981;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {

    MovieDBManager movieDBManager;

    EditText etSearch;
    String searchWord;
    TextView tvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        etSearch = findViewById(R.id.etSearch);
        tvResult = findViewById(R.id.tvResult);

        movieDBManager = new MovieDBManager(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_search:

                searchWord = etSearch.getText().toString();

                tvResult.setText(movieDBManager.getMoviesByNation(searchWord).toString());
                break;
        }
    }
}
