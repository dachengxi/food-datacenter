package me.cxis.fdc.model;

import java.io.Serial;
import java.io.Serializable;

public class Nutrient implements Serializable {

    @Serial
    private static final long serialVersionUID = -5257717133700455775L;

    private Long id;

    private Channel channel;

    private String code;

    private String name;

    private String description;

    private String displayName;

    private String abbreviation;

    private Integer order;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Nutrient{" +
                "id=" + id +
                ", channel=" + channel +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", displayName='" + displayName + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", order=" + order +
                '}';
    }
}
