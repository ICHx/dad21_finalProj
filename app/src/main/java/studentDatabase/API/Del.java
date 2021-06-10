package studentDatabase.API;

import io.javalin.http.Context;
import studentDatabase.DBUtil;
import studentDatabase.Pojo.*;

public class Del {
    public static void dept(Context ctx) {
        System.out.println(ctx.body());
        Dept dpt = ctx.bodyAsClass(Dept.class);
        String result = "Success";
        try {
            DBUtil.delete(dpt);
        } catch (Exception e) {
            result = e.getMessage();
        } finally {
            ctx.result(result);
        }
    }
    
    public static void depthead(Context ctx) {
        System.out.println(ctx.body());
        var dpt = ctx.bodyAsClass(DeptHead.class);
        String result = "Success";
        try {
            DBUtil.delete(dpt);
        } catch (Exception e) {
            result = e.getMessage();
        } finally {
            ctx.result(result);
        }
    }
    
    public static void course(Context ctx) {
        System.out.println(ctx.body());
        var dpt = ctx.bodyAsClass(Course.class);
        String result = "Success";
        try {
            DBUtil.delete(dpt);
        } catch (Exception e) {
            result = e.getMessage();
        } finally {
            ctx.result(result);
        }
    }
    
    public static void account(Context ctx) {
        System.out.println(ctx.body());
        var dpt = ctx.bodyAsClass(Account.class);
        String result = "Success";
        try {
            DBUtil.delete(dpt);
        } catch (Exception e) {
            result = e.getMessage();
        } finally {
            ctx.result(result);
        }
    }
    
    public static void enroll(Context ctx) {
        System.out.println(ctx.body());
        var dpt = ctx.bodyAsClass(Enroll.class);
        String result = "Success";
        try {
            DBUtil.delete(dpt);
        } catch (Exception e) {
            result = e.getMessage();
        } finally {
            ctx.result(result);
        }
    }
    
    public static void teach(Context ctx) {
        System.out.println(ctx.body());
        var dpt = ctx.bodyAsClass(Teach.class);
        String result = "Success";
        try {
            DBUtil.delete(dpt);
        } catch (Exception e) {
            result = e.getMessage();
        } finally {
            ctx.result(result);
        }
    }
}
