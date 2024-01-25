package com.shencangblue.design.icrs.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shencangblue.design.icrs.entity.LoginLogs;
import com.shencangblue.design.icrs.mapper.LoginLogsMapper;
import com.shencangblue.design.icrs.queryVo.LoginLogsVo;
import com.shencangblue.design.icrs.result.Result;
import com.shencangblue.design.icrs.result.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/login_logs")
public class LoginLogsController {
    @Autowired
    private LoginLogsMapper loginLogsMapper;

    @GetMapping("/get")
    public Result get(LoginLogsVo loginLogsVo, int currentPage, int size) {
        Page<LoginLogs> page = new Page<>(currentPage, size);
        QueryWrapper<LoginLogs> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("login_time");
        if (loginLogsVo.getUsername() != null) {
            wrapper.like("username", loginLogsVo.getUsername());
        }

        if (loginLogsVo.getStartTime() != null) {
            wrapper.ge("login_time", loginLogsVo.getStartTime());
        }

        if (loginLogsVo.getEndTime() != null) {
            wrapper.le("login_time", loginLogsVo.getEndTime());
        }
        Page<LoginLogs> loginLogsPage = loginLogsMapper.selectPage(page, wrapper);
        return ResultFactory.buildSuccessResult(loginLogsPage);
    }
}

