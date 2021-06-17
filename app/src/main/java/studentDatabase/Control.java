package studentDatabase;

import io.javalin.http.Context;
import studentDatabase.Pojo.Password;

public class Control {
    public static void loginCheck(Context ctx) {

        //protect forms
        String path = ctx.path();
        String user = ctx.sessionAttribute("currentUser");

        if (path.contains("forms")) {
            if (user == null) {
                ctx.redirect("/");
            }
        } else {
            return;
        }
    }

    public static void isLoggedIn(Context ctx) {
        if (ctx.sessionAttribute("currentUser") == null) {
            ctx.result("0");
        } else {
            ctx.result("1");
        }
    }

    public static void login(Context ctx) {
        System.out.println("/login");
        var body = ctx.bodyAsClass(Password.class);
        var result = body.validate();
        if (App.DEBUG == 1) {
            System.out.println("Received combination " + body + " is " + result);
        }

        if (result) {
            ctx.sessionAttribute("currentUser", body.getNetid());
        }

        ctx.result(result ? "1" : "0");
        return;
    }

    public static void logout(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.req.getSession().invalidate();
        ctx.redirect("/");
        return;
    }
}
