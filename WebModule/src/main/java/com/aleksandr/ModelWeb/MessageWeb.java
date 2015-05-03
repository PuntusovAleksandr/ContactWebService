package com.aleksandr.ModelWeb;

import java.util.Date;

/**
 * Created by Aleksandr on 27.04.2015.
 */
public class MessageWeb {
    private long id;

    private long fromId;

    private long toId;

    private String content;

    private Date date;

    public MessageWeb(long id, long fromId, Date date, String content, long toId) {
        this.id = id;
        this.fromId = fromId;
        this.date = date;
        this.content = content;
        this.toId = toId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFromId() {
        return fromId;
    }

    public void setFromId(long fromId) {
        this.fromId = fromId;
    }

    public long getToId() {
        return toId;
    }

    public void setToId(long toId) {
        this.toId = toId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
