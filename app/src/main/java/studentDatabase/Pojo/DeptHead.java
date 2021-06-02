package studentDatabase.Pojo;


public class DeptHead {

  private String headid;
  private String fordeptid;
  
  public DeptHead(String headid, String fordeptid) {
    this.headid = headid;
    this.fordeptid = fordeptid;
  }
  
  public String getHeadid() {
    return headid;
  }

  public void setHeadid(String headid) {
    this.headid = headid;
  }

  public String getFordeptid() {
    return fordeptid;
  }

  public void setFordeptid(String fordeptid) {
    this.fordeptid = fordeptid;
  }

}
