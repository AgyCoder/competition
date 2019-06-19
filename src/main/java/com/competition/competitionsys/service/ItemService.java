package com.competition.competitionsys.service;

import com.competition.competitionsys.domain.ItemModel;
import com.competition.competitionsys.domain.VO.ResponseData;

import java.util.List;

public interface ItemService {

    ResponseData findAllItems();

    ResponseData addItem(ItemModel itemModel);

    ResponseData deleteItem(Integer id);

    ResponseData findItemById(Integer id);

    ResponseData updateItem(Integer id,ItemModel itemModel);

    ResponseData findItemByTeacherId(Integer teacherId);
}
