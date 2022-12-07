package me.cxis.fdc.model;

import java.io.Serial;
import java.io.Serializable;

public class Brand implements Serializable {

    @Serial
    private static final long serialVersionUID = -1979212915148691014L;

    private Long id;

    private Channel channel;

    private String code;

    private String name;

    private BrandOwner brandOwner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BrandOwner getBrandOwner() {
        return brandOwner;
    }

    public void setBrandOwner(BrandOwner brandOwner) {
        this.brandOwner = brandOwner;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", channel=" + channel +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", brandOwner=" + brandOwner +
                '}';
    }
}
