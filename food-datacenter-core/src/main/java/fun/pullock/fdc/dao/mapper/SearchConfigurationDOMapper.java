package fun.pullock.fdc.dao.mapper;

import fun.pullock.fdc.dao.model.SearchConfigurationDO;

public interface SearchConfigurationDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SearchConfigurationDO row);

    int insertSelective(SearchConfigurationDO row);

    SearchConfigurationDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SearchConfigurationDO row);

    int updateByPrimaryKey(SearchConfigurationDO row);
}