package me.cxis.fdc.model.param;

public class FoodIdQueryParam {

    private Long id;

    private String channel;

    private String languageCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    @Override
    public String toString() {
        return "FoodIdQueryParam{" +
                "id=" + id +
                ", channel='" + channel + '\'' +
                ", languageCode='" + languageCode + '\'' +
                '}';
    }
}
