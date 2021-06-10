package studentDatabase.Pojo;

import lombok.Data;

@Data
public class Teach {
    
    private String teacherid;
    private String deptid;
    private long courseid;
    
    public Teach(String teacherid, String deptid, long courseid) {
        this.teacherid = teacherid;
        this.deptid = deptid;
        this.courseid = courseid;
    }
    
    public Teach() {
    }
    
    
}
