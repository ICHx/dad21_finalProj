package studentDatabase.Pojo;

public class Course {
private String deptid;
private String courseid;
private String coursename;
private String remarks;
public Course(String deptid, String courseid, String coursename, String remarks) {
    this.deptid = deptid;
    this.courseid = courseid;
    this.coursename = coursename;
    this.remarks = remarks;
}
public String getDeptid() {
    return deptid;
}
public void setDeptid(String deptid) {
    this.deptid = deptid;
}
public String getCourseid() {
    return courseid;
}
public void setCourseid(String courseid) {
    this.courseid = courseid;
}
public String getCoursename() {
    return coursename;
}
public void setCoursename(String coursename) {
    this.coursename = coursename;
}
public String getRemarks() {
    return remarks;
}
public void setRemarks(String remarks) {
    this.remarks = remarks;
}
}
