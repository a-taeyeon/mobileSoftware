package ddwucom.mobile.test11.exam01;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FoodManager {

    ArrayList<Food> foodList;

    public FoodManager() {
        foodList = new ArrayList<Food>();
        foodList.add(new Food("김치찌개", "한국"));   //DTO형태로정의된거임(Food객체가 문자열로 바뀌어서 보여짐)
        foodList.add(new Food("된장찌개", "한국"));
        foodList.add(new Food("훠궈", "중국"));
        foodList.add(new Food("딤섬", "중국"));
        foodList.add(new Food("초밥", "일본"));
        foodList.add(new Food("오코노미야키", "일본"));
    }

    public ArrayList<Food> getFoodList() {
        return foodList;
    }

    public void addFoodd(Food food){
        foodList.add(food);
    }


    public void deleteFood(int index){
        foodList.remove(index);
    }

}
