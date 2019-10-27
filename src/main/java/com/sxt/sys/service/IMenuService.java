package com.sxt.sys.service;

import com.sxt.sys.domain.Menu;
import com.sxt.sys.vo.MenuVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMenuService {
    /**
     * 超级管理员查询所有菜单
     */
    List<Menu> queryAllMenu(MenuVO menuVO);

    /**
     * 根据用户Id查询用户可用菜单
     */
    List<Menu> queryMenuByUserIdForList(MenuVO menuVO,Integer userId);
}
