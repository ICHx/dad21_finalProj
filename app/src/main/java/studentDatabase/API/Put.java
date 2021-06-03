package studentDatabase.API;

import io.javalin.http.Context;
import studentDatabase.DBUtil;
import studentDatabase.Pojo.Dept;

/**
 * This class add/update row to database
 */
public class Put {


    public static void dept(Context ctx) {
        System.out.println(ctx.body());
        Dept dpt = ctx.bodyAsClass(Dept.class);
        String result = "Success";
        try {
            DBUtil.insert(dpt);
        } catch (Exception e) {
            result = e.getMessage();
        } finally {
            ctx.result(result);
        }
    }


}
