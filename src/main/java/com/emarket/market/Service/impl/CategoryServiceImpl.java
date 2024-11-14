package com.emarket.market.Service.impl;

import com.emarket.market.Service.CategoryService;
import com.emarket.market.constant.EmarketConst;
import com.emarket.market.dao.CategoryMapper;
import com.emarket.market.pojo.Category;
import com.emarket.market.vo.CategoryVo;
import com.emarket.market.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public ResponseVo<List<CategoryVo>> list() {
        List<Category> categories = categoryMapper.selectAll();
        List<CategoryVo> categoryVoList = new ArrayList<>();
        for(Category category : categories){
            if(category.getParentId().equals(EmarketConst.ROOT_PARENT_ID)){
                CategoryVo categoryVo = new CategoryVo();
                BeanUtils.copyProperties(category, categoryVo);
                categoryVoList.add(categoryVo);
            }
            categoryVoList.sort(Comparator.comparingInt(CategoryVo::getSortOrder).reversed());
            findsubCategory(categoryVoList, categories);
        }
        return ResponseVo.sucess(categoryVoList);
    }

    private void findsubCategory(List<CategoryVo> categoryVoList, List<Category> categories) {
        for(CategoryVo categoryVo : categoryVoList) {
            List<CategoryVo> subCategoryVoList = new ArrayList<>();
            for(Category category : categories) {
                if(categoryVo.getId().equals(category.getParentId())) {
                    CategoryVo subCategoryVo = new CategoryVo();
                    BeanUtils.copyProperties(category, subCategoryVo);
                    subCategoryVoList.add(subCategoryVo);
                }
                subCategoryVoList.sort(Comparator.comparingInt(CategoryVo::getSortOrder).reversed());
                categoryVo.setSubCategories(subCategoryVoList);
                findsubCategory(subCategoryVoList, categories);
            }
        }
    }
}
