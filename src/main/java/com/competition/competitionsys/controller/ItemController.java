package com.competition.competitionsys.controller;

import com.competition.competitionsys.domain.ItemModel;
import com.competition.competitionsys.domain.VO.ResponseData;
import com.competition.competitionsys.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    /**
     * 查找所有项目
     * @return
     */
    @RequestMapping("/findAllItems")
    public ResponseData findAllItems(){
        return  itemService.findAllItems();
    }

    /**
     * 添加项目并返回项目编号
     * @param itemModel
     * @return
     */
    @RequestMapping(value = "/addItem",method = RequestMethod.POST)
    @Transactional
    public ResponseData addItem(@RequestBody @Valid ItemModel itemModel){
        //处理接受到json参数的情况
        if(null!=itemModel){
            return itemService.addItem(itemModel);
        } else {
            //处理未接受到json参数的情况
            return new ResponseData("网络错误!");
        }
    }

    /**
     * 通过项目id删除
     * @param id
     * @return
     */
    @RequestMapping(value="/deleteItem/{id}",method = RequestMethod.GET)
    public ResponseData deleteItem(@PathVariable Integer id){
        return itemService.deleteItem(id);
    }

    /**
     * 通过项目id查找
     * @param id
     * @return
     */
    @RequestMapping(value="/findItemById",method = RequestMethod.GET)
    public ResponseData findItemById(@RequestBody Integer id){
        return itemService.findItemById(id);
    }


    /**
     *修改项目
     * @param itemModel
     * @return
     */
    @RequestMapping(value="/updateItem",method=RequestMethod.POST)
    public ResponseData updateItem(@RequestBody ItemModel itemModel) {
        Integer id = itemModel.getId();
        return itemService.updateItem(id,itemModel);
    }

    /**
     * 查找某一老师的项目
     * @param id
     * @return
     */
    @RequestMapping(value = "findItemByTeacherId/{id}",method = RequestMethod.GET)
    public ResponseData findItemByTeacherId(@PathVariable Integer id){
        return itemService.findItemByTeacherId(id);
    }
}
