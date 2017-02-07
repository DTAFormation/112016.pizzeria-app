package fr.pizzeria.admin.web.activity;

import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * Created by Fawzi NASSIM on 06/02/2017.
 */
public class ActivityItemEncoder implements Encoder.Text<ActivityItem> {
    @Override
    public String encode(ActivityItem activityItem) throws EncodeException {
        return Json.createObjectBuilder()
                .add("origin", activityItem.getOrigin())
                .add("sender", activityItem.getSender())
                .add("action", activityItem.getAction())
                .add("received", activityItem.getReceived().toString()).build()
                .toString();
    }

    @Override
    public void init(EndpointConfig config) {

    }

    @Override
    public void destroy() {

    }
}
