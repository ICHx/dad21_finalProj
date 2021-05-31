package studentDatabase;

import org.sql2o.Sql2o;

public class DBUtil {
    private Sql2o sql2o;
    public DBUtil(){
        this.sql2o = new Sql2o("jdbc:mysql://192.168.0.202/college","phone","sql12345");
    }
    public Sql2o getSql2o() {
        return sql2o;
    }
    
}
