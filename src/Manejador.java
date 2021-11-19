import java.io.Console;

import org.json.JSONObject;
import Server.SSSAbstract.SSSessionAbstract;
import Servisofts.SConsole;
import component.*;

public class Manejador {
    public static void onMessage(JSONObject obj, SSSessionAbstract session) {
        String sessionId = "";
        if (session != null) {
            sessionId = session.getIdSession();
        }
        SConsole.log(sessionId, "\t|\t", obj.getString("component"), obj.getString("type"));
        switch (obj.getString("component")) {
        case "test":
            System.out.println("Hola");
            break;
        }

    }

}
