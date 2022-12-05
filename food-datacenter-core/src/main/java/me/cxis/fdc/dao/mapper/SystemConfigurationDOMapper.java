package me.cxis.fdc.dao.mapper;

import me.cxis.fdc.dao.model.SystemConfigurationDO;

public interface SystemConfigurationDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemConfigurationDO row);

    int insertSelective(SystemConfigurationDO row);

    SystemConfigurationDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemConfigurationDO row);

    int updateByPrimaryKey(SystemConfigurationDO row);
}