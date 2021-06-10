package studentDatabase.Template;

import io.javalin.http.Context;
import studentDatabase.DBUtil;

import java.util.HashMap;

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
            var d = DBUtil.findDept(deptid); // null if not found
            map.put("obj", d);
            map.put("msg", "Success");
        } catch (Exception e) {
            map.put("msg", e.getMessage());
        } finally {
            // ?template engine hate null
            ctx.render("/templates/dept.html", map);
        }
    }
}
