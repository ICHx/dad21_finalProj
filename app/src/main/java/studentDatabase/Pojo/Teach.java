package studentDatabase.Pojo;

public class Teach {

  private String teacherid;
  private String deptid;
  private long courseid;
  
  public Teach(String teacherid, String deptid, long courseid) {
    this.teacherid = teacherid;
    this.deptid = deptid;
    this.courseid = courseid;
  }
  
  public String getTeacherid() {
    return teacherid;
  }

  public void setTeacherid(String teacherid) {
    this.teacherid = teacherid;
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
