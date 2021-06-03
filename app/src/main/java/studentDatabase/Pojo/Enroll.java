package studentDatabase.Pojo;


import lombok.Data;

@Data
public class Enroll {

  private String studentid;
  private String deptid;
  private long courseid;
  
  public Enroll(String studentid, String deptid, long courseid) {
    this.studentid = studentid;
    this.deptid = deptid;
    this.courseid = courseid;
  }

  public Enroll() {
  }
  


}
