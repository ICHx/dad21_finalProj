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

    // * helper
    private static void updateBind(Object a, String sql) {
        try (var con = sql2o.beginTransaction()) {
            con.createQuery(sql).bind(a).executeUpdate();
            con.commit();
        }
    }

    // ! CRUD : Create
    public static void insert(Dept d) {
        var sql = "insert into Dept(deptid,deptname ,deptaddress,deptphone)\n"
                + "values (:deptid, :deptname, :deptaddress, :deptphone)";
        try {
            updateBind(d, sql);

        } catch (Exception e) {
            System.out.println("Try update dept");
            update(d);
        }
    }

    public static void insert(Course c) {
        // ! not neccessary to update
        var sql = "insert into Course(deptid, courseid, coursename, remarks)\n"
                + "values (:deptid, :courseid, :coursename, :remarks)";

        updateBind(c, sql);
    }

    public static void insert(Account a) {
        var sql = "insert into Account(netid, firstname, lastname, deptid, gender, phone)\n"
                + "values (:netid, :firstname, :lastname, :deptid, :gender, :phone)";
        try {
            updateBind(a, sql);
        } catch (Exception e) {
            System.out.println("Try update dept");
            update(a);
        }
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
        // ! directly replace
        var sql = "replace into Teach(teacherid,deptid ,courseid)\n" + "values (:teacherid, :deptid, :courseid)";
        updateBind(t, sql);
    }

    // ! CRUD : Update, for unreplacable entries
    public static void update(Dept d) {
        var sql = "update Dept SET\n" + "deptname=:deptname, deptaddress=:deptaddress, deptphone=:deptphone\n"
                + "WHERE deptid=:deptid";
        updateBind(d, sql);
    }

    public static void update(Account a) {
        var sql = "update Account SET\n"
                + "firstname=:firstname, lastname=:lastname, deptid=:deptid, gender=:gender, phone=:phone\n"
                + "WHERE netid=:netid";
        updateBind(a, sql);
    }

    // ! Delete
    // delete from Dept where deptid="";
    public static void delete(Dept d) {
        // ! department should never be deleted
        var sql = "delete from Dept where deptid=:deptid";
        updateBind(d, sql);
    }

    public static void delete(Course c) {
        // ! not neccessary to update
        var sql1 = "delete from Enroll where deptid=:deptid and courseid=:courseid";
        var sql2 = "delete from Teach where deptid=:deptid and courseid=:courseid";
        var sql3 = "delete from Course where deptid=:deptid and courseid=:courseid";
        updateBind(c, sql1);
        updateBind(c, sql2);
        updateBind(c, sql3);
    }

    public static void delete(Account a) {
        var sql1 = "delete from Enroll where studentid=:netid";
        var sql2 = "delete from Teach where teacherid=:netid";
        var sql3 = "delete from Account where netid=:netid)";
        updateBind(a, sql1);
        updateBind(a, sql2);
        updateBind(a, sql3);

    }

    public static void delete(DeptHead dh) {
        var sql = "delete from DeptHead where headid=:headid or fordeptid=:fordeptid)";
        updateBind(dh, sql);
    }

    public static void delete(Enroll e) {
        var sql = "delete from Enroll where studentid=:studentid and deptid=:deptid and courseid=:courseid";
        updateBind(e, sql);
    }

    public static void delete(Teach t) throws Exception {
        throw new Exception("E: Instructor should only be replaced");
    }

    // ! CRUD: read / find

    public static Dept findDept(String deptid) {
        var sql = "select * from Dept where deptid=:val";
        try (var con = sql2o.open()) {
            var obj = con.createQuery(sql).addParameter("val", deptid).executeAndFetchFirst(Dept.class);
            return obj;
        }
    }

    public static Account findAccount(String key) {

        var sql = "select * from Dept where netid=:val";
        try (var con = sql2o.open()) {
            var obj = con.createQuery(sql).addParameter("val", key).executeAndFetchFirst(Account.class);
            return obj;
        }
    }

    public static DeptHead findDepthead(String key) {

        var sql = "select * from DeptHead where fordeptid=:val or headid=:val";
        try (var con = sql2o.open()) {
            var obj = con.createQuery(sql).addParameter("val", key).executeAndFetchFirst(DeptHead.class);
            return obj;
        }
    }

    public static Course findCourse(String deptid, String courseid) {
        var sql = "select * from Course where deptid=:val1 and courseid=:val2";
        try (var con = sql2o.open()) {
            var obj = con.createQuery(sql).addParameter("val1", deptid).addParameter("val2", courseid)
                    .executeAndFetchFirst(Course.class);

            return obj;
        }
    }

    public static Enroll findEnroll(String keyword) {
        // Find who enrolled, find enrolled by who

        // select * from Enroll where studentid='122235d' and deptid='ISE' and
        // courseid=101;
        var sql = "select * from Enroll where studentid=:val1 or deptid=:val1 or courseid=:val1";
        try (var con = sql2o.open()) {
            var obj = con.createQuery(sql).addParameter("val1", keyword).executeAndFetchFirst(Enroll.class);

            return obj;
        }
    }

    public static Teach findTeach(String id) {
        // select * from Teach where deptid='ISE' and courseid=101;
        var sql = "select * from Teach where teacherid=:val1";
        try (var con = sql2o.open()) {
            var obj = con.createQuery(sql).addParameter("val1", id).executeAndFetchFirst(Teach.class);

            return obj;
        }
    }

    // ! CRUD: read / List
    public static List<Dept> findDept() {
        var sql = "select * from Dept";
        try (var con = sql2o.open()) {
            var obj = con.createQuery(sql).executeAndFetch(Dept.class);
            return obj;
        }
    }

    public static List<Account> findAccount() {
        var sql = "select * from Account";
        try (var con = sql2o.open()) {
            var obj = con.createQuery(sql).executeAndFetch(Account.class);
            return obj;
        }
    }

    public static List<DeptHead> findDepthead() {
        var sql = "select * from DeptHead";
        try (var con = sql2o.open()) {
            var obj = con.createQuery(sql).executeAndFetch(DeptHead.class);
            return obj;
        }
    }

    public static List<Course> findCourse() {
        var sql = "select * from Course";
        try (var con = sql2o.open()) {
            var obj = con.createQuery(sql).executeAndFetch(Course.class);
            return obj;
        }
    }

    public static List<Enroll> findEnroll() {
        var sql = "select * from Enroll";
        try (var con = sql2o.open()) {
            var obj = con.createQuery(sql).executeAndFetch(Enroll.class);
            return obj;
        }
    }

    public static List<Teach> findTeach() {
        var sql = "select * from Teach";
        try (var con = sql2o.open()) {
            var obj = con.createQuery(sql).executeAndFetch(Teach.class);
            return obj;
        }
    }

}
