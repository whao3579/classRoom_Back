package com.shencangblue.design.icrs.aspect;

import com.shencangblue.design.icrs.entity.LoginLogs;
import com.shencangblue.design.icrs.mapper.LoginLogsMapper;
import com.shencangblue.design.icrs.model.User;
import com.shencangblue.design.icrs.result.Result;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
@Component
public class LoginLogsAspect {
    @Autowired
    private LoginLogsMapper loginLogsMapper;

    @Pointcut("execution(* com.shencangblue.design.icrs.controller.LoginController.login(..))")
    private void pointCut() {
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    private void afterReturning(JoinPoint joinPoint, Object result) {
        //获取ip地址
        HttpServletRequest request = getHttpServletRequest();
        String ipAddress = request.getRemoteAddr();
        //获取登录时间
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = currentTime.format(formatter);
        //获取请求参数user
        Object[] args = joinPoint.getArgs();
        User user = (User) args[0];
        //获取login方法的返回结果
        Result res = (Result) result;
        LoginLogs loginLogs = new LoginLogs();
        loginLogs.setLoginTime(formattedTime);
        loginLogs.setIpAddress(ipAddress);
        loginLogs.setUsername(user.getUsername());
        loginLogs.setStatus(res.getCode() == 200 ? 1 : 0);
        loginLogs.setMessage(res.getMessage());
        loginLogsMapper.insert(loginLogs);
    }

    private HttpServletRequest getHttpServletRequest() {
        //获取上下文信息
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        return request;
    }
}
