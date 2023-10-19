package fun.pullock.fdc.dao.mapper;

import fun.pullock.fdc.dao.model.UnitLanguageDO;
import org.apache.ibatis.annotations.Param;

public interface UnitLanguageDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UnitLanguageDO row);

    int insertSelective(UnitLanguageDO row);

    UnitLanguageDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UnitLanguageDO row);

    int updateByPrimaryKey(UnitLanguageDO row);

    UnitLanguageDO selectByUnitIdAndLanguageCode(@Param("unitId") Long unitId, @Param("languageCode") String languageCode);
}