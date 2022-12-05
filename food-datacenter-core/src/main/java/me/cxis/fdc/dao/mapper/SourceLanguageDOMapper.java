package me.cxis.fdc.dao.mapper;

import me.cxis.fdc.dao.model.SourceLanguageDO;

public interface SourceLanguageDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SourceLanguageDO row);

    int insertSelective(SourceLanguageDO row);

    SourceLanguageDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SourceLanguageDO row);

    int updateByPrimaryKey(SourceLanguageDO row);
}