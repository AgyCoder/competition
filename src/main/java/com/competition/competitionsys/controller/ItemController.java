package com.competition.competitionsys.controller;

import com.competition.competitionsys.dao.ItemDao;
import com.competition.competitionsys.domain.ItemModel;
import com.competition.competitionsys.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/findAllItems")
    public List<ItemModel> findAllItems(){
        List<ItemModel> allItems = itemService.findAllItems();
        return allItems;
    }
}
