package com.competition.competitionsys.controller;

import com.competition.competitionsys.dao.ItemDao;
import com.competition.competitionsys.domain.ItemModel;
import com.competition.competitionsys.domain.Req.ReqItemModel;
import com.competition.competitionsys.domain.VO.ResponseData;
import com.competition.competitionsys.domain.WebCts;
import com.competition.competitionsys.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/findAllItems")
    @ResponseBody
    public List<ItemModel> findAllItems(){
        List<ItemModel> allItems = itemService.findAllItems();
        return allItems;
    }

    @RequestMapping(value = "/addItem",method = RequestMethod.POST)
    @Transactional
    @ResponseBody
    public ResponseData addItem(@RequestBody @Valid ItemModel itemModel){

        //处理接受到json参数的情况
        if(null!=itemModel){
            if(itemService.addItem(itemModel)==1) {
                //添加成功,返回项目id
                Integer id = itemModel.getId();
                return new ResponseData(WebCts.RESP_SUCCESS, id);
            }else{
                //添加失败,返回错误信息
                return new ResponseData(WebCts.RESP_FAIL);
            }
        } else {
            //处理未接受到json参数的情况
            return new ResponseData(WebCts.RESP_FAIL);
        }
    }
}
