package studentDatabase.Pojo;

import lombok.Data;
import lombok.NonNull;

@Data
public class DeptHead {
    
    @NonNull
    private String fordeptid;
    private String headid;
    
    public DeptHead(String headid, String fordeptid) throws Exception {
        this.setHeadid(headid);
        this.fordeptid = fordeptid;
    }
    
    public DeptHead() {
    }
    
    public void setHeadid(String headid) throws Exception {
        if (headid.contains("t")) {
            this.headid = headid;
        } else {
            throw new Exception("DeptHead: Not instructor.");
        }
    }
}
