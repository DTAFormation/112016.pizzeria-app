/**
 * Created by Fawzi NASSIM on 06/02/2017.
 */
package fr.pizzeria.admin.web.activity;

import javax.inject.Inject;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@ServerEndpoint(value = "/activity", encoders = ActivityItemEncoder.class, decoders = ActivityItemDecoder.class)
public class ActivityWS {
    private final Logger log = Logger.getLogger(getClass().getName());

    @Inject
    ActivitySessionManager am;

    @OnOpen
    public void open(final Session session) {

        this.am.setSession(session);
        System.out.println("===================> Init WS");
    }

    @OnClose
    public void close(final Session session) {

        this.am.setSession(session);
    }

    @OnMessage
    public void onMessage(final Session session, final ActivityItem activityItem) {
        try {
            for (Session s : am.getSession().getOpenSessions()) {
                if (s.isOpen()) {
                    s.getBasicRemote().sendObject(activityItem);
                }
            }
        } catch (IOException | EncodeException e) {
            log.log(Level.WARNING, "onMessage failed", e);
        }
    }


}
