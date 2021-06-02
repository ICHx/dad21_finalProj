package studentDatabase;

import org.sql2o.Sql2o;
import studentDatabase.Pojo.*;

public class DBUtil {
    private static final Sql2o sql2o;
    static {
        sql2o = new Sql2o("jdbc:mysql://192.168.0.202/college","phone","sql12345");
    }
    public static Sql2o getSql2o() {
        return sql2o;
    }
    
    
    // ! CRUD : Create
    public static void insert(Account a) {
        var sql = "insert into Account(netid, firstname, lastname, deptid, gender, phone)\n"
            + "values (:netid, :firstname, :lastname, :deptid, :gender, :phone)";
        applyBind(a, sql);
    }
    
    public static void insert(Course c) {
        var sql = "insert into Course(deptid, courseid, coursename, remarks)\n"
            + "values (:deptid, :courseid, :coursename, :remarks)";
        applyBind(c, sql);
    }
    
    public static void insert(Dept d) {
        var sql = "insert into Dept(deptid,deptname ,deptaddress,deptphone)\n"
            + "values (:deptid, :deptname, :deptaddress, :deptphone)";
        applyBind(d, sql);
    }
    
    public static void insert(DeptHead dh) {
        var sql = "insert into DeptHead(headid, fordeptid)\n"
            + "values (:headid, :fordeptid)";
        applyBind(dh, sql);
    }
    
    public static void insert(Enroll e) {
        var sql = "insert into Enroll(studentid,deptid ,courseid)\n"
            + "values (:studentid, :deptid, :courseid)";
        applyBind(e, sql);
    }
    
    public static void insert(Teach t) {
        var sql = "insert into Teach(teacherid,deptid ,courseid)\n"
            + "values (:teacherid, :deptid, :courseid)";
        applyBind(t, sql);
    }
    
    // ! Remove
    
    
    // ! etc
    private static void applyBind(Object a, String sql) {
        var sql2o = DBUtil.getSql2o();
        try (var con = sql2o.beginTransaction()) {
            con.createQuery(sql).bind(a).executeUpdate();
            con.commit();
        }
    }
    
}
