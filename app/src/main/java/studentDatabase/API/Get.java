package studentDatabase.API;

import io.javalin.http.Context;
import studentDatabase.DBUtil;

/**
 * *Get "key", find entries matched
 */
public class Get {
    static String NOTFOUND = "not found";
    
    public static void dept(Context ctx) {
        var key = ctx.queryParam("key");
        System.out.println("accessed /api/dept/get");
        try {
            var d = DBUtil.findDept(key);
            ctx.json(d);
        } catch (Exception e) {
            ctx.result(e.getMessage());
        }
    }
    
    public static void account(Context ctx) {
        System.out.println("accessed /api/account/get");
        var key = ctx.queryParam("key");
        try {
            var ac = DBUtil.findAccount(key);
            ctx.json(ac);
        } catch (Exception e) {
            ctx.result(e.getMessage());
        }
    }
    
    public static void depthead(Context ctx) {
        System.out.println("accessed /api/depthead/get");
        var key = ctx.queryParam("key");
        try {
            var dh = DBUtil.findDepthead(key);
            if(dh==null){
                ctx.result(NOTFOUND);
                return;
            }
            ctx.json(dh);
        } catch (Exception e) {
            ctx.result(e.getMessage());
        }
    }
    
    public static void course(Context ctx) {
        var deptid = ctx.queryParam("deptid");
        var courseid = ctx.queryParam("courseid");
        System.out.println("accessed /api/course/get");
        try {
            var c = DBUtil.findCourse(deptid, courseid);
            ctx.json(c);
        } catch (Exception e) {
            ctx.result(e.getMessage());
        }
    }
    
    public static void enroll(Context ctx) {
        var key = ctx.queryParam("key");
        System.out.println("accessed /api/enroll/get");
        try {
            var ac = DBUtil.findEnroll(key);
            ctx.json(ac);
        } catch (Exception e) {
            ctx.result(e.getMessage());
        }
    }
    
    public static void teach(Context ctx) {
        var key = ctx.queryParam("key");
        System.out.println("accessed /api/teach/list");
        try {
            var ac = DBUtil.findTeach(key);
            ctx.json(ac);
        } catch (Exception e) {
            ctx.result(e.getMessage());
        }
    }
    
    
}
