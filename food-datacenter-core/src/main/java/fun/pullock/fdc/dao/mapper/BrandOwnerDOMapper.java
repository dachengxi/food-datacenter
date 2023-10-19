package fun.pullock.fdc.dao.mapper;

import fun.pullock.fdc.dao.model.BrandOwnerDO;

public interface BrandOwnerDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(BrandOwnerDO row);

    int insertSelective(BrandOwnerDO row);

    BrandOwnerDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BrandOwnerDO row);

    int updateByPrimaryKey(BrandOwnerDO row);
}