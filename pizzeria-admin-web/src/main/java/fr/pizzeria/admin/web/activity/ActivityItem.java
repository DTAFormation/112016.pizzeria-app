/**
 * Created by Fawzi NASSIM on 06/02/2017.
 */

package fr.pizzeria.admin.web.activity;

import java.util.Date;

public class ActivityItem {

    private String origin;
    private String action;
    private String sender;
    private Date received;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getSender() {
        return this.sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Date getReceived() {
        return received;
    }

    public void setReceived(Date received) {
        this.received = received;
    }

}
