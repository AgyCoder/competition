package com.competition.competitionsys.dao;

import com.competition.competitionsys.domain.ItemModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface ItemDao {

    //查看所有竞赛项目
    List<ItemModel> findAllItems();

    //添加比赛项目
    Integer addItem(ItemModel itemModel);

    //删除比赛项目
    Integer deleteItem(Integer id);

    ItemModel findItemById(Integer id);

    Integer updateItem(ItemModel itemModel);
}
