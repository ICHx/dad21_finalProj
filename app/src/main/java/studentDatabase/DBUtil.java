package studentDatabase;

import java.util.List;

import org.sql2o.Sql2o;

import studentDatabase.Pojo.Account;
import studentDatabase.Pojo.Course;
import studentDatabase.Pojo.Dept;
import studentDatabase.Pojo.DeptHead;
import studentDatabase.Pojo.Enroll;
import studentDatabase.Pojo.Teach;

public class DBUtil {
    private static final Sql2o sql2o;
    static {
        sql2o = new Sql2o("jdbc:mysql://192.168.0.202/college", "phone", "sql12345");
    }

    public static Sql2o getSql2o() {
        return sql2o;
    }

    // ! CRUD : Create/Update
    public static void insert(Dept d) {
        var sql = "replace into Dept(deptid,deptname ,deptaddress,deptphone)\n"
                + "values (:deptid, :deptname, :deptaddress, :deptphone)";
        updateBind(d, sql);
    }

    public static void insert(Course c) {
        var sql = "insert into Course(deptid, courseid, coursename, remarks)\n"
                + "values (:deptid, :courseid, :coursename, :remarks)";
        updateBind(c, sql);
    }

    public static void insert(Account a) {
        var sql = "insert into Account(netid, firstname, lastname, deptid, gender, phone)\n"
                + "values (:netid, :firstname, :lastname, :deptid, :gender, :phone)";
        updateBind(a, sql);
    }

    public static void insert(DeptHead dh) {
        // ! directly replace
        var sql = "replace into DeptHead(headid, fordeptid)\n" + "values (:headid, :fordeptid)";
        updateBind(dh, sql);
    }

    public static void insert(Enroll e) {
        var sql = "insert into Enroll(studentid,deptid ,courseid)\n" + "values (:studentid, :deptid, :courseid)";
        updateBind(e, sql);
    }

    public static void insert(Teach t) {
        var sql = "insert into Teach(teacherid,deptid ,courseid)\n" + "values (:teacherid, :deptid, :courseid)";
        updateBind(t, sql);
    }

    // ! Delete
    // delete from Dept where deptid="";
    
    
    // ! CRUD: read
    public static Dept findDept(String deptid) {
            var sql = "select * from Dept where deptid=:val";
            try (var con = sql2o.open()) {
                var obj = con.createQuery(sql)
                .addParameter("val", deptid)
                .executeAndFetchFirst(Dept.class);
                return obj;
            }
        }

    // ! etc
    private static void updateBind(Object a, String sql) {
        try (var con = sql2o.beginTransaction()) {
            con.createQuery(sql).bind(a).executeUpdate();
            con.commit();
        }
    }
    


}
