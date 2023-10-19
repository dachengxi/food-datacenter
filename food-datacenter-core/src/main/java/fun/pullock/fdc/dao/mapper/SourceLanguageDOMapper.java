package fun.pullock.fdc.dao.mapper;

import fun.pullock.fdc.dao.model.SourceLanguageDO;
import org.apache.ibatis.annotations.Param;

public interface SourceLanguageDOMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SourceLanguageDO row);

    int insertSelective(SourceLanguageDO row);

    SourceLanguageDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SourceLanguageDO row);

    int updateByPrimaryKey(SourceLanguageDO row);

    SourceLanguageDO selectBySourceIdAndLanguageCode(@Param("sourceId") Long sourceId, @Param("languageCode") String languageCode);
}