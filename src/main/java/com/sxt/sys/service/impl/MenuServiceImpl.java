package com.sxt.sys.service.impl;

import com.sxt.sys.domain.Menu;
import com.sxt.sys.mapper.MenuMapper;
import com.sxt.sys.service.IMenuService;
import com.sxt.sys.vo.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements IMenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> queryAllMenu(MenuVO menuVO) {
        return menuMapper.queryAllMenu(menuVO);
    }

    /**
     * 权限管理
     * @param menuVO
     * @param userId
     * @return
     */
    @Override
    public List<Menu> queryMenuByUserIdForList(MenuVO menuVO, Integer userId) {
        return menuMapper.queryAllMenu(menuVO);
    }
}
