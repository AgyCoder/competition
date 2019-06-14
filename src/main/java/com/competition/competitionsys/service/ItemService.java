package com.competition.competitionsys.service;

import com.competition.competitionsys.domain.ItemModel;
import com.competition.competitionsys.domain.VO.ResponseData;

public interface ItemService {

    ResponseData findAllItems();

    ResponseData addItem(ItemModel itemModel);

    ResponseData deleteItem(Integer id);
}
