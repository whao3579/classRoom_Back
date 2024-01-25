package com.shencangblue.design.icrs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author Ychen
 * @since 2024-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LoginLogs implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    private String loginTime;

    private String ipAddress;

    private int status;

    private String message;


}
