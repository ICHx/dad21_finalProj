package studentDatabase;

import io.javalin.Javalin;
import studentDatabase.API.Del;
import studentDatabase.API.Get;
import studentDatabase.API.Ls;
import studentDatabase.API.Put;
import studentDatabase.Template.View;

public class App {
    /**
    * Web Configurations
    */
    public final static int PORT = 4567;
    public final static int DEBUG = 1;

    public static void main(String[] args) {
        route();
    }

    public static void route() {
        var app = Javalin.create(config -> {
            config.addStaticFiles("public");
            // config.addStaticFiles("vue");
        }).start(PORT);

        app.before(Control::loginCheck);
        app.get("/isLoggedIn", Control::isLoggedIn);
        app.post("/login", Control::login);
        app.get("/logout", Control::logout);

        app.get("/view/dept/get", View::dept); // template view

        app.get("/api/dept/get", Get::dept); // API view
        app.get("/api/dept/list", Ls::dept); // API List
        app.put("/api/dept/add", Put::dept); // API put
        app.put("/api/dept/del", Del::dept); // API del

        app.get("/api/depthead/get", Get::depthead); // API view
        app.get("/api/depthead/list", Ls::depthead); // API List
        app.put("/api/depthead/add", Put::depthead); // API put
        app.put("/api/depthead/del", Del::depthead); // API del

        app.get("/api/course/get", Get::course); // API view
        app.get("/api/course/list", Ls::course); // API List
        app.put("/api/course/add", Put::course); // API put
        app.put("/api/course/del", Del::course); // API del

        app.get("/api/account/get", Get::account); // API view
        app.get("/api/account/list", Ls::account); // API List
        app.put("/api/account/add", Put::account); // API put
        app.put("/api/account/del", Del::account); // API del

        app.get("/api/enroll/get", Get::enroll); // API view
        app.get("/api/enroll/list", Ls::enroll); // API List
        app.put("/api/enroll/add", Put::enroll); // API put
        app.put("/api/enroll/del", Del::enroll); // API del

        app.get("/api/teach/get", Get::teach); // API view
        app.get("/api/teach/list", Ls::teach); // API List
        app.put("/api/teach/add", Put::teach); // API put
        app.put("/api/teach/del", Del::teach); // API del
    }
}
