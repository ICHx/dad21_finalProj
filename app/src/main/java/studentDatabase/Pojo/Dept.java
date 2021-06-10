package studentDatabase.Pojo;

import lombok.Data;
import lombok.NonNull;

@Data
public class Dept {
    @NonNull 
    private String deptid;
    private String deptname;
    private String deptaddress;
    private int deptphone;
    
    public Dept() {
    } // needed for JSON serialization
    
    public Dept(String deptid, String deptname, String deptaddress, int deptphone) {
        this.deptid = deptid;
        this.deptname = deptname;
        this.deptaddress = deptaddress;
        this.deptphone = deptphone;
    }
    
    public void setDeptid(String deptid) throws Exception {
        if (deptid.isBlank()) {
            throw new Exception("Empty bean id.");
        }
        this.deptid = deptid.toUpperCase();
    }
    
}
