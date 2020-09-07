//과제명: 영화 정보 관리 앱
//분반: 01분반
//학번: 20180981   성명: 안태연
//제출일: 2020년 7월 2일

package ddwucom.mobile.finalreport.final_report_01_20180981;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";
    final int REQ_CODE = 100;
    final int UPDATE_CODE = 200;
    final int SEARCH_CODE = 300;

    ListView listView;
    MyAdapter myAdapter;
    ArrayList<Movie> movieList = null;
    MovieDBManager movieDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.customListView);
        movieList = new ArrayList();
        myAdapter = new MyAdapter(this, R.layout.custom_adapter_view, movieList);
        listView.setAdapter(myAdapter);
        movieDBManager = new MovieDBManager(this);

        //클릭 시 항목 수정
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movie = movieList.get(position);
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                intent.putExtra("movie", movie);
                startActivityForResult(intent, UPDATE_CODE);
            }
        });

        //롱클릭 시 항목 삭제
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int pos = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("영화 삭제")
                        .setMessage(movieList.get(pos).getTitle() + " 영화를 삭제하시겠습니까?")
                        .setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (movieDBManager.removeMovie(movieList.get(pos).get_id())) {
//                                    Toast.makeText(MainActivity.this, "삭제 완료", Toast.LENGTH_SHORT).show();
                                    movieList.clear();
                                    movieList.addAll(movieDBManager.getAllMovie());
                                    myAdapter.notifyDataSetChanged();
                                } else {
                                    Toast.makeText(MainActivity.this, "삭제 실패", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton(R.string.dialog_cancel, null)
                        .setCancelable(false)
                        .show();
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        movieList.clear();
        movieList.addAll(movieDBManager.getAllMovie());
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.menuAdd:
                Intent intent = new Intent(this, AddActivity.class);
                startActivityForResult(intent, REQ_CODE);
                break;

            case R.id.menuSearch:
                Intent searchIntent = new Intent(this, SearchActivity.class);
                startActivityForResult(searchIntent, SEARCH_CODE);


//                Toast.makeText(MainActivity.this, movieDBManager.getMoviesByNation("korea").toString(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.menuIntroduce:
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.custom_introduce_dialog);

                TextView tv = (TextView)dialog.findViewById(R.id.tv_developer_text);
                tv.setText("안녕하세요.\n모바일소프트웨어\n01분반\n20180981\n안태연입니다.");

                ImageView iv = (ImageView)dialog.findViewById(R.id.img_developer_picture);
                iv.setImageResource(R.drawable.developer_picture);

                dialog.show();
                break;

            case R.id.menuTermination:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("앱 종료")
                        .setMessage("앱을 종료하시겠습니까?")
                        .setNegativeButton("취소", null)
                        .setPositiveButton("종료", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finishAffinity();
                                System.runFinalization();
                                System.exit(0);
                            }
                        })
                        .setCancelable(false)
                        .show();
                break;
        }
        return true;
    }
}