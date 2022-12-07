package me.cxis.fdc.model;

import java.io.Serial;
import java.io.Serializable;

public class Unit implements Serializable {

    @Serial
    private static final long serialVersionUID = -6690798515731420725L;

    private Long id;

    private String code;

    private Integer type;

    private String name;

    private String description;

    private String displayName;

    private String abbreviation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", displayName='" + displayName + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                '}';
    }
}
