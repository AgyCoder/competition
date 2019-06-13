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
    public List<ItemModel> findAllItems();

    //添加比赛项目
    public Integer addItem(ItemModel itemModel);
}
