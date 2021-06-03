package studentDatabase;

import java.util.HashMap;

import io.javalin.http.Context;

public class Serve {
    public static void testRender(Context ctx) {
        System.out.println("accessed template");
        var map = new HashMap<String, String>();
        map.put("user2", "Eric");
        ctx.render("/templates/indextemplate.html", map);
    }
}
