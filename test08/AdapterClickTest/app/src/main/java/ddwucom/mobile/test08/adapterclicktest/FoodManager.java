package ddwucom.mobile.test08.adapterclicktest;

import java.util.ArrayList;

public class FoodManager {
    private ArrayList<String> foodList;

    public FoodManager() {
        foodList = new ArrayList();
        foodList.add("떡볶이");
        foodList.add("치킨");
        foodList.add("마라탕");
        foodList.add("피자");
        foodList.add("칼국수");
        foodList.add("아이스아메리카노");
        foodList.add("삼겹살");
    }

    public ArrayList<String> getFoodList() {
        return foodList;
    }

//    추가
    public void addData(String newSubject) {
        foodList.add(newSubject);
    }

//    삭제
    public void removeData(int idx) {
        foodList.remove(idx);
    }

    //몇번째에 해당하는 원본데이터를 반환해줌
    public String getItem(int pos){
        return foodList.get(pos);
    }
    //수정
    public void updateData(int pos, String updateSubject){
        foodList.set(pos, updateSubject);
    }
}
