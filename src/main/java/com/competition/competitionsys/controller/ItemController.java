package com.competition.competitionsys.controller;

import com.competition.competitionsys.domain.ItemModel;
import com.competition.competitionsys.domain.VO.ResponseData;
import com.competition.competitionsys.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/findAllItems")
    @ResponseBody
    public ResponseData findAllItems(){
        return  itemService.findAllItems();
    }

    @RequestMapping(value = "/addItem",method = RequestMethod.POST)
    @Transactional
    @ResponseBody
    public ResponseData addItem(@RequestBody @Valid ItemModel itemModel){
        //处理接受到json参数的情况
        if(null!=itemModel){
            return itemService.addItem(itemModel);
        } else {
            //处理未接受到json参数的情况
            return new ResponseData("网络错误!");
        }
    }

    @RequestMapping(value="/deleteItem/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData deleteItem(@PathVariable Integer id){
        if (null!=id)
            return itemService.deleteItem(id);
        else
            return new ResponseData("网络错误");
    }
}
