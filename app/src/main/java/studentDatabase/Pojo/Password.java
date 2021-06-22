package studentDatabase.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import studentDatabase.DBUtil;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Password {
    @NonNull private String netid;
    @NonNull private String pin;

    public boolean validate(){
        return DBUtil.checkPassword(this);
    }
    public void hash(){
        var hpin = this.pin.length() + this.pin;
        this.pin=hpin;
    }
}
