package com.competition.competitionsys.service.impl;

import com.competition.competitionsys.dao.ItemDao;
import com.competition.competitionsys.domain.ItemModel;
import com.competition.competitionsys.domain.VO.ResponseData;
import com.competition.competitionsys.domain.WebCts;
import com.competition.competitionsys.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ItemService")
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;

    /**
     * 查找所有项目
     * @return项目列表
     */
    public ResponseData findAllItems() {
        List<ItemModel> itemModelList=itemDao.findAllItems();
        return new ResponseData(WebCts.RESP_SUCCESS,itemModelList);
    }


    /**
     * 添加项目
     * @param itemModel
     * @return项目编号
     */
    @Override
    public ResponseData addItem(ItemModel itemModel) {
        if(1==itemDao.addItem(itemModel)) {
            //添加成功,返回项目id
            Integer id = itemModel.getId();
            return new ResponseData(WebCts.RESP_SUCCESS, id);
        }else{
            //添加失败,返回错误信息
            return new ResponseData(WebCts.RESP_FAIL);
        }
    }

    /**
     * 删除项目
     * @param项目id
     * @return操作成功或者失败消息
     */
    public ResponseData deleteItem(Integer id){
        if(1==itemDao.deleteItem(id))
            return new ResponseData(WebCts.RESP_SUCCESS);
        else
            return new ResponseData(WebCts.RESP_FAIL);
    }

    /**
     * 通过项目id查找项目
     * @param id
     * @return对应的结果
     */
    public ResponseData findItemById(Integer id){
        ItemModel itemModel=itemDao.findItemById(id);
        if(null!=itemModel)
            return new ResponseData(WebCts.RESP_SUCCESS,itemModel);
        else
            return new ResponseData(WebCts.RESP_FAIL);
    }

    /**
     *修改项目
     * @param id
     * @param itemModel
     * @return
     */
    public ResponseData updateItem(Integer id,ItemModel itemModel){
        itemModel.setId(id);
        if(1==itemDao.updateItem(itemModel))
            return new ResponseData(WebCts.RESP_SUCCESS,itemModel);
        else
            return new ResponseData(WebCts.RESP_FAIL);

    }

    /**
     * 查看某一个老师的项目
     * @param teacherId
     * @return相关的项目集合
     */
    public ResponseData findItemByTeacherId(Integer teacherId){
        List<ItemModel> itemModelList = itemDao.findItemByTeacherId(teacherId);
        return new ResponseData(WebCts.RESP_SUCCESS,itemModelList);
    }

}
