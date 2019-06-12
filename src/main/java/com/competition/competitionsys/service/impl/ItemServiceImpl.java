package com.competition.competitionsys.service.impl;

import com.competition.competitionsys.domain.ItemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.competition.competitionsys.dao.ItemDao;
import com.competition.competitionsys.service.ItemService;

import java.util.List;

@Service("ItemService")
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;

    public List<ItemModel> findAllItems() {
        return itemDao.findAllItems();
    }
}
