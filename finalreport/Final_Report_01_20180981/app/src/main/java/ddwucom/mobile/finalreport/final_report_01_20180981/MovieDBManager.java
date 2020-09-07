package ddwucom.mobile.finalreport.final_report_01_20180981;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;

public class MovieDBManager {

    final String TAG = "MovieDBManager";

    MovieDBHelper movieDBHelper = null;
    Cursor cursor = null;

    public MovieDBManager(Context context){
        movieDBHelper = new MovieDBHelper(context);
    }

    //    DB의 모든 movie를 반환
    public ArrayList<Movie> getAllMovie() {
        ArrayList MovieList = new ArrayList();
        SQLiteDatabase db = movieDBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + MovieDBHelper.TABLE_NAME, null);

        while(cursor.moveToNext()) {
            long id = cursor.getInt(cursor.getColumnIndex(MovieDBHelper.COL_ID));
            String title = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_TITLE));
            String nation = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_NATION));
            String director = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_DIRECTOR));
            String releaseDate = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_RELEASEDATE));
            String genre = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_GENRE));
            MovieList.add ( new Movie (id, title, nation, director, releaseDate, genre) );
        }

        cursor.close();
        movieDBHelper.close();
        return MovieList;
    }

    //    DB 에 새로운 movie 추가
    public boolean addNewMovie(Movie newFood) {
        SQLiteDatabase db = movieDBHelper.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(MovieDBHelper.COL_TITLE, newFood.getTitle());
        value.put(MovieDBHelper.COL_NATION, newFood.getNation());
        value.put(MovieDBHelper.COL_DIRECTOR, newFood.getDirector());
        value.put(MovieDBHelper.COL_RELEASEDATE, newFood.getReleaseDate());
        value.put(MovieDBHelper.COL_GENRE, newFood.getGenre());

//      insert 메소드를 사용할 경우 데이터 삽입이 정상적으로 이루어질 경우 1 이상, 이상이 있을 경우 0 반환 확인 가능
        long count = db.insert(MovieDBHelper.TABLE_NAME, null, value);
        movieDBHelper.close();
        if (count > 0) return true;
        return false;
    }

    //    _id 를 기준으로 movie 의 정보 변경
    public boolean modifyMovie(Movie movie) {
        SQLiteDatabase sqLiteDatabase = movieDBHelper.getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put(MovieDBHelper.COL_TITLE, movie.getTitle());
        row.put(MovieDBHelper.COL_NATION, movie.getNation());
        row.put(MovieDBHelper.COL_DIRECTOR, movie.getDirector());
        row.put(MovieDBHelper.COL_RELEASEDATE, movie.getReleaseDate());
        row.put(MovieDBHelper.COL_GENRE, movie.getGenre());
        String whereClause = MovieDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(movie.get_id()) };
        int result = sqLiteDatabase.update(MovieDBHelper.TABLE_NAME, row, whereClause, whereArgs);
        movieDBHelper.close();
        if (result > 0) return true;
        return false;
    }

    //    _id 를 기준으로 DB에서 movie 삭제
    public boolean removeMovie(long id) {
        SQLiteDatabase sqLiteDatabase = movieDBHelper.getWritableDatabase();
        String whereClause = MovieDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(id) };
        int result = sqLiteDatabase.delete(MovieDBHelper.TABLE_NAME, whereClause,whereArgs);
        movieDBHelper.close();
        if (result > 0) return true;
        return false;
    }

    //    나라 이름으로 DB 검색
    public ArrayList<Movie> getMoviesByNation(String searchNation) {
        ArrayList MovieList = new ArrayList();
        SQLiteDatabase db = movieDBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + MovieDBHelper.TABLE_NAME + " WHERE " + MovieDBHelper.COL_NATION + " LIKE '%" + searchNation + "%'", null);
        while(cursor.moveToNext()) {
            long id = cursor.getInt(cursor.getColumnIndex(MovieDBHelper.COL_ID));
            String title = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_TITLE));
            String nation = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_NATION));
            String director = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_DIRECTOR));
            String releaseDate = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_RELEASEDATE));
            String genre = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_GENRE));
            MovieList.add ( new Movie (id, title, nation, director, releaseDate, genre) );
        }

        cursor.close();
        movieDBHelper.close();
        return MovieList;
    }

    //    close 수행
    public void close() {
        if (movieDBHelper != null) movieDBHelper.close();
        if (cursor != null) cursor.close();
    };
}
