package ddwucom.mobile.test08.adapterviewtest;

import java.util.ArrayList;

public class subjectManager {

    private ArrayList<String> subjectList;

    public subjectManager(){
        subjectList = new ArrayList();
        subjectList.add("모바일소프트웨어");
        subjectList.add("네트워크");
        subjectList.add("웹서비스");
        subjectList.add("운영체제");
        subjectList.add("웹프로그래밍2");
    }

    public ArrayList<String> getSubjectList() {
        return subjectList;
    }

    //추가
    public void addData(String newSubject){
        subjectList.add(newSubject);
    }

    //삭제
    public void removeData(int pos){
        subjectList.remove(pos);
    }

    //몇번째에 해당하는 원본데이터를 반환해줌
    public String getItem(int pos){
        return subjectList.get(pos);
    }
    //수정
    public void updateData(int pos, String updateSubject){
        subjectList.set(pos, updateSubject);
    }
}
