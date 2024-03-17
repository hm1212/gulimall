package com.atguigu.gulimall.product.service.impl;


import com.atguigu.gulimall.common.utils.PageUtils;
import com.atguigu.gulimall.common.utils.Query;
import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //1.查出所有分类
        List<CategoryEntity> entities = this.baseMapper.selectList(null);
        //2.获取一级分类
        List<CategoryEntity> list = entities
                .stream()
                .filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                .map(menu -> {
                    menu.setChildren(getChildren(menu, entities));
                    return menu;
                })
                .sorted((menu1, menu2) -> {
                    return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
                })
                .collect(Collectors.toList());


        return list;
    }

    @Override
    public void removeMenusByids(List<Long> catIds) {
        //todo  //1.检查当前菜单是否被其他引用
        baseMapper.deleteBatchIds(catIds);
    }

    public List<CategoryEntity> getChildren(CategoryEntity parentMenu, List<CategoryEntity> all) {
        return all.stream().filter(categoryEntity -> parentMenu.getCatId() == categoryEntity.getParentCid())
                  .map(menu -> {
                      menu.setChildren(getChildren(menu, all));
                      return menu;
                  })
                  .sorted((menu1, menu2) -> {
                      return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
                  })
                  .collect(Collectors.toList());
    }

}