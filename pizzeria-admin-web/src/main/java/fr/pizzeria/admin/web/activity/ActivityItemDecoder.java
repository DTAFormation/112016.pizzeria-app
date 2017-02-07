package fr.pizzeria.admin.web.activity;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.StringReader;
import java.util.Date;

/**
 * Created by Fawzi NASSIM on 06/02/2017.
 */
public class ActivityItemDecoder implements Decoder.Text<ActivityItem> {
    @Override
    public ActivityItem decode(final String textMessage) throws DecodeException {

        ActivityItem activityItem = new ActivityItem();
        JsonObject obj = Json.createReader(new StringReader(textMessage))
                .readObject();
        activityItem.setOrigin(obj.getString("origin"));
        activityItem.setSender(obj.getString("sender"));
        activityItem.setAction(obj.getString("action"));
        activityItem.setReceived(new Date());
        return activityItem;
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }

    @Override
    public void init(EndpointConfig config) {

    }

    @Override
    public void destroy() {

    }
}
