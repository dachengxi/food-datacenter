package fun.pullock.fdc.dao.model;

import java.time.LocalDateTime;

public class SystemConfigurationDO {
    private Long id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String creatorId;

    private String modifierId;

    private Boolean deleted;

    private Long channelId;

    private Boolean enableSearch;

    private String searchServiceName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getModifierId() {
        return modifierId;
    }

    public void setModifierId(String modifierId) {
        this.modifierId = modifierId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Boolean getEnableSearch() {
        return enableSearch;
    }

    public void setEnableSearch(Boolean enableSearch) {
        this.enableSearch = enableSearch;
    }

    public String getSearchServiceName() {
        return searchServiceName;
    }

    public void setSearchServiceName(String searchServiceName) {
        this.searchServiceName = searchServiceName;
    }
}