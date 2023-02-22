package dyrepark;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.json.JsonMapper;
import io.javalin.vue.VueComponent;
import dyrepark.model.Dyr;
import dyrepark.model.Panda;
import dyrepark.model.Sjimpanse;

import java.util.ArrayList;
import java.time.LocalDate;


public class Application {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.staticFiles.enableWebjars();
            config.vue.vueAppName = "app";
        }).start(7070);

// TODO: 22.02.2023 JSON mapper må fikses, ellers blir det server error 
        
        
        //VueComponent må matche id-en i vue filen
        app.get("/", new VueComponent("hello-world"));

        app.get("/dyrepark/{dyrepark-id}", new VueComponent("dyrepark-detail"));

        ArrayList<Dyr> dyreListe = new ArrayList<Dyr>();
        dyreListe.add(new Sjimpanse("Arne", LocalDate.now(), 30));
        dyreListe.add(new Panda("Nils", LocalDate.now(), "Gul"));

        app.get("/api/dyrepark/{dyrepark-navn}", new Handler() {
            @Override
            public void handle(Context context){
                context.json(dyreListe);
            }
        });


    }
}
