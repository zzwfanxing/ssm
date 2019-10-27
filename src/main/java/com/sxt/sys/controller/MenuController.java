package com.sxt.sys.controller;

import com.sxt.sys.constast.SysConstast;
import com.sxt.sys.domain.Menu;
import com.sxt.sys.domain.User;
import com.sxt.sys.service.impl.MenuServiceImpl;
import com.sxt.sys.utils.TreeNode;
import com.sxt.sys.utils.TreeNodesBuilder;
import com.sxt.sys.utils.WebUtils;
import com.sxt.sys.vo.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单管理控制页面
 */
@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
   private MenuServiceImpl menuService;


    @RequestMapping ("loadIndexLeftMenuJosn")
    public List<TreeNode> loadIndexLeftMenuJosn(MenuVO menuVO){
        //得到当前用户的对象
        User user = (User) WebUtils.getHttpSession().getAttribute("user");
        List <Menu> list=null;
        menuVO.setAvailable(SysConstast.AVAILABLE_TRUE);//只查询可以用的菜单
        if (user.getType()==SysConstast.USER_TYPE_SUPER){
            list=this.menuService.queryAllMenu(menuVO);
        } else{
            list=this.menuService.queryMenuByUserIdForList(menuVO,user.getUserid());
        }
        List<TreeNode> nodes =new ArrayList<>();
        for (Menu menu: list) {
            Integer id =menu.getId();
            Integer pid=menu.getPid();
            String title=menu.getTitle();
            String icon=menu.getIcon();
           String href=menu.getHref();
            boolean spread=menu.getSpread()==SysConstast.SPREAD_TURE?true:false;
            String target=menu.getTarget();
            nodes.add(new TreeNode(id,pid,title,icon,href,spread,target));
        }


        return TreeNodesBuilder.builder(nodes,1);
    }

}


