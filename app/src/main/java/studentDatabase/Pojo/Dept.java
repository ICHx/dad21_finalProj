package studentDatabase.Pojo;

public class Dept {
    private String deptid;
    private String deptname;
    private String deptaddress;
    private int deptphone;
    public Dept(String deptid, String deptname, String deptaddress, int deptphone) {
        this.deptid = deptid;
        this.deptname = deptname;
        this.deptaddress = deptaddress;
        this.deptphone = deptphone;
    }
    public String getDeptid() {
        return deptid;
    }
    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }
    public String getDeptname() {
        return deptname;
    }
    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }
    public String getDeptaddress() {
        return deptaddress;
    }
    public void setDeptaddress(String deptaddress) {
        this.deptaddress = deptaddress;
    }
    public int getDeptphone() {
        return deptphone;
    }
    public void setDeptphone(int deptphone) {
        this.deptphone = deptphone;
    } 
}
