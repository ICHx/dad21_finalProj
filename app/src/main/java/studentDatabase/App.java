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
        app.put("/api/dept/add", Put::dept);  //API put
        
    }
    

    
}
