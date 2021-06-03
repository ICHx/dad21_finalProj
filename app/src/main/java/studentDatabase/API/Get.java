package studentDatabase.API;

import io.javalin.http.Context;
import studentDatabase.DBUtil;
import studentDatabase.Pojo.Dept;

public class Get {
    public static void dept(Context ctx) {
        // todo: sql2o -> obj -> json
        var deptid = ctx.queryParam("deptid");
        // ?fordeptid=xxx
        System.out.println("accessed /api/dept/get");
        try {
            var d = DBUtil.findDept(deptid);
            ctx.json(d);
        } catch (Exception e) {
            ctx.result(e.getMessage());
        }
    }

    public static void account(Context ctx) {

    }

    public static void depthead(Context ctx) {

    }
}
