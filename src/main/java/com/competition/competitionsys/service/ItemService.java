package com.competition.competitionsys.service;

import com.competition.competitionsys.domain.ItemModel;
import com.competition.competitionsys.domain.VO.ResponseData;

import java.util.List;

public interface ItemService {

    ResponseData findAllItems();

    ResponseData addItem(ItemModel itemModel);
}
