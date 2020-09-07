package ddwucom.mobile.finalreport.final_report_01_20180981;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Movie implements Serializable {

    long _id;
    String title;
    String nation;
    String director;
    String releaseDate;
    String genre;

    public Movie(String title, String nation) {
        this.title = title;
        this.nation = nation;
    }

    public Movie(String title, String nation, String director, String releaseDate, String genre) {
        this.title = title;
        this.nation = nation;
        this.director = director;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public Movie(long _id, String title, String nation, String director, String releaseDate, String genre) {
        this._id = _id;
        this.title = title;
        this.nation = nation;
        this.director = director;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
//        sb.append(_id);
//        sb.append(".\t");
        sb.append("\n");
        sb.append(nation);
        sb.append("\t\t-\t\t");
        sb.append(title);
        sb.append("\t\t");
//        sb.append(director);
        sb.append("\t\t");
//        sb.append(releaseDate);
//        sb.append("\t\t");
//        sb.append(genre);
        sb.append("\n");
        return sb.toString();
    }
}
