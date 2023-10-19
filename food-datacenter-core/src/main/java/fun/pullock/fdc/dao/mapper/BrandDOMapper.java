package fun.pullock.fdc.dao.mapper;

import fun.pullock.fdc.dao.model.BrandDO;

public interface BrandDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(BrandDO row);

    int insertSelective(BrandDO row);

    BrandDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BrandDO row);

    int updateByPrimaryKey(BrandDO row);
}