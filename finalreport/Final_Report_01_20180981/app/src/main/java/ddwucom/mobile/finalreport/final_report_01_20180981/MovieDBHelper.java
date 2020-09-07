package ddwucom.mobile.finalreport.final_report_01_20180981;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MovieDBHelper extends SQLiteOpenHelper {
    final static String TAG = "MovieDBHelper";

    final static String DB_NAME = "movies.db";
    public final static String TABLE_NAME = "movie_table";

    public final static String COL_ID = "_id";
    public final static String COL_TITLE = "title";
    public final static String COL_NATION = "nation";
    public final static String COL_DIRECTOR = "director";
    public final static String COL_RELEASEDATE = "releaseDate";
    public final static String COL_GENRE = "genre";

   public MovieDBHelper(Context context){
       super(context, DB_NAME, null, 1);
   }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " integer primary key autoincrement, " +
                COL_TITLE + " TEXT, " +
                COL_NATION + " TEXT, " +
                COL_DIRECTOR + " TEXT, " +
                COL_RELEASEDATE + " TEXT, " +
                COL_GENRE + " TEXT)";
        Log.d(TAG, sql);
        db.execSQL(sql);

        db.execSQL("insert into " + TABLE_NAME + " values(null, '클래식', 'korea', '곽재용', '2003.01.30', '멜로/로맨스, 드라마');");
        db.execSQL("insert into " + TABLE_NAME + " values(null, '해리포터와 마법사의 돌', 'uk', '크리스 콜럼버스', '2001.12.14', '판타지, 가족, 모험');");
        db.execSQL("insert into " + TABLE_NAME + " values(null, '그 시절, 우리가 좋아했던 소녀', 'taiwan', '구파도', '2012.08.22', '멜로/로맨스, 드라마');");
        db.execSQL("insert into " + TABLE_NAME + " values(null, '하울의 움직이는 성', 'japan', '미야자키 하야호', '2004.12.23', '애니메이션, 판타지');");
        db.execSQL("insert into " + TABLE_NAME + " values(null, '내가 널 사랑할 수 없는 10가지 이유', 'usa', '길 정거', '1999.03.31', '코미디, 멜로/로맨스');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
