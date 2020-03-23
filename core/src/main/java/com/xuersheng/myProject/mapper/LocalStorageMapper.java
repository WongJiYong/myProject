package com.xuersheng.myProject.mapper;

import com.xuersheng.myProject.model.LocalStorage;
import com.xuersheng.myProject.model.example.LocalStorageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LocalStorageMapper {

    long countByExample(LocalStorageExample example);

    int deleteByExample(LocalStorageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LocalStorage record);

    int insertSelective(LocalStorage record);

    List<LocalStorage> selectByExample(LocalStorageExample example);

    LocalStorage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LocalStorage record, @Param("example") LocalStorageExample example);

    int updateByExample(@Param("record") LocalStorage record, @Param("example") LocalStorageExample example);

    int updateByPrimaryKeySelective(LocalStorage record);

    int updateByPrimaryKey(LocalStorage record);
}
