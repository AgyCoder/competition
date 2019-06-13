package com.competition.competitionsys;

import com.competition.competitionsys.dao.ItemDao;
import com.competition.competitionsys.dao.UserDao;
import com.competition.competitionsys.domain.ItemModel;
import com.competition.competitionsys.domain.UserModel;
import com.competition.competitionsys.service.ItemService;
import com.competition.competitionsys.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=CompetitionsysApplication.class)
public class MapperTest {

    @Autowired
    private UserDao userDao;
    @Autowired
    private ItemDao itemDao;

    @Autowired
    private ItemService itemService;
    @Test
    public void testuser(){
        List<UserModel>users = userDao.findAllUsers();
        System.out.println(users);
    }

    @Test
    public void testaddItem(){
        ItemModel itemModel=new ItemModel();
        itemModel.setItemName("国际象棋");
        itemModel.setCategoryId(1);
        itemService.addItem(itemModel);
        Integer id=itemModel.getId();
        System.out.println(id);
    }

    @Test
    public void testitem(){
        List<ItemModel>items = itemDao.findAllItems();
        System.out.println(items);
    }
}
