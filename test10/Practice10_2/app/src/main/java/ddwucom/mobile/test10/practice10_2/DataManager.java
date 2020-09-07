package ddwucom.mobile.test10.practice10_2;

import java.util.ArrayList;

public class DataManager {

    private ArrayList<MyData> myDataList;

    public DataManager() {
        myDataList = new ArrayList<>();

        myDataList.add(new MyData(1, "하월곡동", "서울시 성북구", "좋음"));
    }

    public ArrayList<MyData> getDataList(){
        return myDataList;
    }

    public void removeData(int pos){
        myDataList.remove(pos);
    }


}
