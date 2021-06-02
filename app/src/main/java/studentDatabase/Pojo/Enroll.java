package studentDatabase.Pojo;

public class Enroll {

  private String studentid;
  private String deptid;
  private long courseid;
  
  public Enroll(String studentid, String deptid, long courseid) {
    this.studentid = studentid;
    this.deptid = deptid;
    this.courseid = courseid;
  }
  
  public String getStudentid() {
    return studentid;
  }

  public void setStudentid(String studentid) {
    this.studentid = studentid;
  }


  public String getDeptid() {
    return deptid;
  }

  public void setDeptid(String deptid) {
    this.deptid = deptid;
  }


  public long getCourseid() {
    return courseid;
  }

  public void setCourseid(long courseid) {
    this.courseid = courseid;
  }

}
