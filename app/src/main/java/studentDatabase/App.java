package studentDatabase;

import io.javalin.Javalin;

import studentDatabase.API.*;
import studentDatabase.Template.View;

public class App {
    
    public final static int PORT = 4567;
    
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.addStaticFiles("public");
            config.addStaticFiles("vue");
        }).start(PORT);
        
        app.get("/test", Serve::testRender);
        
        app.get("/view/dept/get", View::dept); //template view
        app.get("/api/dept/get", Get::dept);  //API view
        app.get("/api/dept/list", Ls::dept);  //API List
        app.put("/api/dept/add", Put::dept);  //API put
        
        app.get("/api/depthead/get", Get::depthead);  //API view
        app.get("/api/depthead/list", Ls::depthead);  //API List
        app.put("/api/depthead/add", Put::depthead);  //API put
        
        app.get("/api/course/get", Get::course);  //API view
        app.get("/api/course/list", Ls::course);  //API List
        app.put("/api/course/add", Put::course);  //API put
        
        app.get("/api/account/get", Get::account);  //API view
        app.get("/api/account/list", Ls::account);  //API List
        app.put("/api/account/add", Put::account);  //API put
        
        app.get("/api/enroll/get", Get::enroll);  //API view
        app.get("/api/enroll/list", Ls::enroll);  //API List
        app.put("/api/enroll/add", Put::enroll);  //API put
        
        app.get("/api/teach/get", Get::teach);  //API view
        app.get("/api/teach/list", Ls::teach);  //API List
        app.put("/api/teach/add", Put::teach);  //API put
        
    }
    

    
}
