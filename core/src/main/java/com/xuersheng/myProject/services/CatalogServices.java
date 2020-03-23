package com.xuersheng.myProject.services;

import com.xuersheng.myProject.db.DataSource;
import com.xuersheng.myProject.mapper.CatalogMapper;
import com.xuersheng.myProject.mapper.ServerInfoMapper;
import com.xuersheng.myProject.model.Catalog;
import com.xuersheng.myProject.model.ServerInfo;
import com.xuersheng.myProject.model.dto.CatalogDto;
import com.xuersheng.myProject.model.example.CatalogExample;
import com.xuersheng.myProject.model.example.ServerInfoExample;
import com.xuersheng.myProject.model.vo.CatalogVo;
import com.xuersheng.myProject.util.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@DataSource("default")
@Transactional
public class CatalogServices {


    @Resource
    CatalogMapper catalogMapper;

    @Resource
    ServerInfoMapper serverInfoMapper;

    public List<CatalogVo> queryCatalog(CatalogDto dto) {
        CatalogExample example = new CatalogExample();
        example.createCriteria()
                .andTypeEqualTo(dto.getType());
        example.setOrderByClause("seq");
        List<Catalog> catalogs = catalogMapper.selectByExample(example);
        return BeanUtils.copyListDeeply(catalogs, CatalogVo.class);
    }

    public boolean modifyCatalog(CatalogDto dto) {
        Catalog catalog = new Catalog();
        BeanUtils.copyPropertiesDeeply(dto, catalog);
        return 1 == catalogMapper.updateByPrimaryKeySelective(catalog);
    }

    public boolean addCatalogNode(CatalogDto dto) {
        Catalog record = new Catalog();
        BeanUtils.copyPropertiesDeeply(dto, record);
        return 1 == catalogMapper.insert(record);
    }

    public boolean removeCatalogNode(CatalogDto dto) {
        //首先检查是否有子目录
        CatalogExample catalogExample = new CatalogExample();
        catalogExample.createCriteria()
                .andParentIdEqualTo(dto.getId());
        List<Catalog> catalogs = catalogMapper.selectByExample(catalogExample);
        if (catalogs.size() != 0) {
            return false;
        }
        //检查目录下是否有服务信息
        ServerInfoExample serverInfoExample = new ServerInfoExample();
        serverInfoExample.createCriteria()
                .andCatalogIdEqualTo(dto.getId());
        List<ServerInfo> serverInfos = serverInfoMapper.selectByExample(serverInfoExample);
        if (serverInfos.size() != 0) {
            return false;
        }
        return 1 == catalogMapper.deleteByPrimaryKey(dto.getId());
    }
}
