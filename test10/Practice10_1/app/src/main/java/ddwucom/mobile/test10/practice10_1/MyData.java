package ddwucom.mobile.test10.practice10_1;

public class MyData {

    private int _id;
    private String name;
    private String detail;
    private String status;

    public MyData(int _id, String name, String detail, String status) {
        this._id = _id;
        this.name = name;
        this.detail = detail;
        this.status = status;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
