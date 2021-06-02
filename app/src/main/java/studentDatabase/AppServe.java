package studentDatabase;

import io.javalin.http.Context;

public class AppServe {
    public static void root(Context ctx) {
        System.out.println("accessed root");
        ctx.render("/index.html");
    }

    // public static Object md(Context ctx) {
    //     ctx.render("/mdtest.md");
    //     return null;
    // }
}
