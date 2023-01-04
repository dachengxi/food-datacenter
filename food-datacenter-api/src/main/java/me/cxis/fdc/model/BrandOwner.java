package me.cxis.fdc.model;

import java.io.Serial;
import java.io.Serializable;

public class BrandOwner implements Serializable {

    @Serial
    private static final long serialVersionUID = 7824656810699120823L;

    private Long id;

    private Long channelId;

    private Channel channel;

    private String code;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BrandOwner{" +
                "id=" + id +
                ", channelId=" + channelId +
                ", channel=" + channel +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
