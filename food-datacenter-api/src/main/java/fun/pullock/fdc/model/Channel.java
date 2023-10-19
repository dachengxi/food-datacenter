package fun.pullock.fdc.model;

import java.io.Serial;
import java.io.Serializable;

public class Channel implements Serializable {

    @Serial
    private static final long serialVersionUID = 3227606904498754237L;

    private Long id;

    private String code;

    private String defaultLanguageCode;

    private Language defaultLanguage;

    private String name;

    private String description;

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

    public String getDefaultLanguageCode() {
        return defaultLanguageCode;
    }

    public void setDefaultLanguageCode(String defaultLanguageCode) {
        this.defaultLanguageCode = defaultLanguageCode;
    }

    public Language getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(Language defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
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

    @Override
    public String toString() {
        return "Channel{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", defaultLanguageCode='" + defaultLanguageCode + '\'' +
                ", defaultLanguage=" + defaultLanguage +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
