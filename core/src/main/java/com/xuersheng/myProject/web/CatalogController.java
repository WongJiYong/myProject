package com.xuersheng.myProject.web;


import com.xuersheng.myProject.services.CatalogServices;
import com.xuersheng.myProject.model.dto.CatalogDto;
import com.xuersheng.myProject.model.vo.CatalogVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static com.xuersheng.myProject.util.ResponseBuilder.ADD_ERROR;
import static com.xuersheng.myProject.util.ResponseBuilder.REMOVE_ERROR;
import static com.xuersheng.myProject.util.ResponseBuilder.MODIFY_ERROR;
import static com.xuersheng.myProject.util.ResponseBuilder.error;
import static com.xuersheng.myProject.util.ResponseBuilder.success;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Resource
    CatalogServices catalogServices;

    @PostMapping("query")
    public ResponseEntity<Object> queryCatalog(@RequestBody CatalogDto dto) {
        List<CatalogVo> catalogVos = catalogServices.queryCatalog(dto);
        return success(catalogVos);
    }

    @PostMapping("modify")
    public ResponseEntity<Object> modifyCatalog(@RequestBody CatalogDto dto) {
        return catalogServices.modifyCatalog(dto) ?
                success() : error(MODIFY_ERROR);
    }

    @PostMapping("add")
    public ResponseEntity<Object> addCatalogNode(@RequestBody CatalogDto dto) {
        return catalogServices.addCatalogNode(dto) ?
                success() : error(ADD_ERROR);
    }

    @PostMapping("remove")
    public ResponseEntity<Object> removeCatalogNode(@RequestBody CatalogDto dto) {
        return catalogServices.removeCatalogNode(dto) ?
                success() : error(REMOVE_ERROR);
    }
}
