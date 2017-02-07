package fr.pizzeria.admin.web.activity;

import fr.pizzeria.model.Pizza;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.EncodeException;
import javax.websocket.Session;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Fawzi NASSIM on 06/02/2017.
 */
@ApplicationScoped
public class ActivitySessionManager {
    private final Logger log = Logger.getLogger(getClass().getName());

    private Session session;

    public void trySend(Pizza pizza) {

        System.out.println(pizza);
        ActivityItem ai = new ActivityItem();
        ai.setOrigin("server");
        ai.setAction("New Pizza");
        ai.setSender("Me");
        ai.setReceived(new Date());

        try {
            for (Session s : this.session.getOpenSessions()) {
                if (s.isOpen()) {
                    s.getBasicRemote().sendObject(ai);
                }
            }
        } catch (IOException | EncodeException e) {
            log.log(Level.WARNING, "onMessage failed", e);
        }
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return this.session;
    }
}
