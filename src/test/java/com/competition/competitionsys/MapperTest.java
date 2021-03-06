package com.competition.competitionsys;

import com.competition.competitionsys.dao.ItemDao;
import com.competition.competitionsys.dao.TeamDao;
import com.competition.competitionsys.dao.UserDao;
import com.competition.competitionsys.domain.ItemModel;
import com.competition.competitionsys.domain.TeacherModel;
import com.competition.competitionsys.domain.UserModel;
import com.competition.competitionsys.service.ItemService;
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
    private TeamDao teamDao;

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
        itemModel.setTeacherId(1);
        itemService.addItem(itemModel);
        Integer id=itemModel.getId();
        System.out.println(id);
    }

    @Test
    public void testitem(){
        List<ItemModel>items = itemDao.findAllItems();
        System.out.println(items);
    }

    @Test
    public void testselectItem(){
        ItemModel itemModel = itemDao.findItemById(2);
        System.out.println(itemModel);
    }

    @Test
    public void testUpdateItem(){
        ItemModel itemModel = itemDao.findItemById(5);
        itemModel.setId(5);
        itemModel.setCategoryId(2);
        System.out.println(itemModel);
        itemModel.setDescription("这是修改后的结果");
        itemDao.updateItem(itemModel);
        System.out.println(itemDao.updateItem(itemModel));

    }

//    @Test
//    public void testFindTeamById(){
//        List<TeamModel> teamModel = (List<TeamModel>) teamDao.findTeamByTeamId(2019);
//        System.out.println(teamModel);
//    }


    @Test
    public void testUpdateTeacherInfo(){
        TeacherModel teacherModel = new TeacherModel();
        teacherModel.setTeacherId(2);
        teacherModel.setName("我修改了");
        userDao.updateTeacherInfo(teacherModel);
        System.out.println(teacherModel);
    }
}
