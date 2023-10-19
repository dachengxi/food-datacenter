package fun.pullock.fdc.model;

import java.io.Serial;
import java.io.Serializable;

public class FoodImage implements Serializable {

    @Serial
    private static final long serialVersionUID = 6635704692840313295L;

    private Long id;

    private Long foodId;

    private String url;

    private Integer order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "FoodImage{" +
                "id=" + id +
                ", foodId=" + foodId +
                ", url='" + url + '\'' +
                ", order=" + order +
                '}';
    }
}
