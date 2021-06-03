package studentDatabase.Template;

import java.util.HashMap;

import io.javalin.http.Context;
import studentDatabase.DBUtil;

/**
 * For server-side templating demonstration only
 */
public class View {
    public static void dept(Context ctx) {
        // template example
        var deptid = ctx.queryParam("deptid");
        // ?fordeptid=xxx
        System.out.println("accessed /view/dept/get");

        var map = new HashMap<String, Object>();

        try {
            var d = DBUtil.findDept(deptid);
            map.put("obj", d);
            map.put("msg", "Success");
        } catch (Exception e) {
            map.put("msg", e.getMessage());
        } finally {
            ctx.render("/templates/dept.html", map);
        }
    }
}
