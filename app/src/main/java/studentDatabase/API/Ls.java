package studentDatabase.API;

import io.javalin.http.Context;
import studentDatabase.DBUtil;

public class Ls {
    public static void dept(Context ctx) {
        System.out.println("accessed /api/dept/list");
        try {
            var d = DBUtil.findDept();
            ctx.json(d);
        } catch (Exception e) {
            ctx.result(e.getMessage());
        }
    }

    public static void account(Context ctx) {
        System.out.println("accessed /api/account/list");
        try {
            var ac = DBUtil.findAccount();
            ctx.json(ac);
        } catch (Exception e) {
            ctx.result(e.getMessage());
        }
    }

    public static void depthead(Context ctx) {
        System.out.println("accessed /api/depthead/list");
        try {
            var dh = DBUtil.findDepthead();
            ctx.json(dh);
        } catch (Exception e) {
            ctx.result(e.getMessage());
        }
    }

    public static void course(Context ctx) {
        System.out.println("accessed /api/course/list");
        try {
            var c = DBUtil.findCourse();
            ctx.json(c);
        } catch (Exception e) {
            ctx.result(e.getMessage());
        }
    }

    public static void enroll(Context ctx) {
        System.out.println("accessed /api/enroll/list");
        try {
            var ac = DBUtil.findEnroll();
            ctx.json(ac);
        } catch (Exception e) {
            ctx.result(e.getMessage());
        }
    }

    public static void teach(Context ctx) {
        System.out.println("accessed /api/teach/list");
        try {
            var ac = DBUtil.findTeach();
            ctx.json(ac);
        } catch (Exception e) {
            ctx.result(e.getMessage());
        }
    }

}
