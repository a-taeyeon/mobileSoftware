package ddwucom.mobile.test12.exam02;

import java.io.Serializable;

public class Food implements Serializable{  //Serializable형태로 만들어져야지 SubActivity에서 Food객체 형태로 넣을 수 있는거임!!
    String food;
    String nation;


    public Food(String food, String nation) {
        this.food = food;
        this.nation = nation;
    }

    public String getFood() {
        return food;
    }

    public String getNation() {
        return nation;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
        return food + "\t\t(" + nation + ")";
    }

}
