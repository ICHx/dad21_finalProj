package studentDatabase.Pojo;

import lombok.Data;

@Data
public class Course {
    private String deptid;
    private int courseid;
    private String coursename;
    private String remarks;
    
    public Course(String deptid, int courseid, String coursename, String remarks) {
        this.deptid = deptid;
        this.courseid = courseid;
        this.coursename = coursename;
        this.remarks = remarks;
    }
    
    public Course() {
    }
    
    public String getDeptid() {
        return deptid;
    }
    
    public void setDeptid(String deptid) throws Exception {
        if (deptid.isBlank()) {
            throw new Exception("Empty bean id.");
        }
        this.deptid = deptid.toUpperCase();
    }
    
    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }
}
