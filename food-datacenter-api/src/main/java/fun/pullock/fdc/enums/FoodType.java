package fun.pullock.fdc.enums;

public enum FoodType {

    RAW(1, "原始食物"),
    COMBINED(2, "组合的食物")
    ;

    private int type;

    private String description;

    FoodType(int type, String description) {
        this.type = type;
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
