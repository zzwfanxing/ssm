package com.sxt.sys.service;

import com.sxt.sys.domain.User;
import com.sxt.sys.vo.UserVo;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User login (UserVo userVo);
}
