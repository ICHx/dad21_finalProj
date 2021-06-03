package studentDatabase.Pojo;

import lombok.Data;

@Data
public class DeptHead {

  private String headid;
  private String fordeptid;
  
  public DeptHead(String headid, String fordeptid) {
    this.headid = headid;
    this.fordeptid = fordeptid;
  }
  public DeptHead(){}


}
