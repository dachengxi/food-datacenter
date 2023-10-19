package fun.pullock.fdc.dao.mapper;

import fun.pullock.fdc.dao.model.SourceDO;

public interface SourceDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SourceDO row);

    int insertSelective(SourceDO row);

    SourceDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SourceDO row);

    int updateByPrimaryKey(SourceDO row);
}